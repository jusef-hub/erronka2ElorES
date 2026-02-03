package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;

import com.ElorServ.ElorServ.model.SocketData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelo.HorarioDTO;
import modelo.ReunionDTO;
import modelo.UserDTO;

public class Bidalketak {

    private static final String HOST = "localhost";
    private static final int PORT = 9000;
    private final Gson gson = new Gson();
    
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private PublicKey serverPublicKey;

   
    public Bidalketak() {}

    // ================= CONEXIÓN Y SEGURIDAD RSA =================
    
    // Conecta al servidor y recibe la clave pública RSA inmediatamente
    public boolean conectar() {
        try {
            if (socket != null && !socket.isClosed()) return true; // Ya conectado

            socket = new Socket(HOST, PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 1. Leer primer mensaje: Clave Pública
            String responseLine = in.readLine();
            if (responseLine != null) {
                SocketData msg = gson.fromJson(responseLine, SocketData.class);
                if ("PUBLIC_KEY".equals(msg.getType())) {
                    String publicKeyStr = (String) msg.getData();
                    this.serverPublicKey = decodificarClavePublica(publicKeyStr);
                    // System.out.println("Conexión establecida y Clave Pública recibida.");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void desconectar() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // ================= LOGIN (Con RSA) =================
    
    public UserDTO login(String user, String pass) {
        try {
            if (!conectar()) return null;

            // 1. Encriptar contraseña con RSA
            String passEncriptada = encriptarRSA(pass);

            // 2. Preparar datos
            Map<String, String> credenciales = new HashMap<>();
            credenciales.put("username", user);
            credenciales.put("password", passEncriptada);

            // 3. Enviar solicitud
            out.println(gson.toJson(new SocketData("LOGIN", credenciales)));

            // 4. Recibir respuesta
            String jsonResponse = in.readLine();
            if (jsonResponse == null) return null;

            SocketData response = gson.fromJson(jsonResponse, SocketData.class);

            if ("LOGIN_OK".equals(response.getType())) {
                // Convertir LinkedTreeMap a UserDTO
                return gson.fromJson(gson.toJson(response.getData()), UserDTO.class);
            } else {
                System.out.println("Login fallido: " + response.getData());
            }

        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        // Nota: No desconectamos aquí para poder seguir usando el socket en la sesión
        // Si prefieres conexión por petición, descomenta: desconectar();
        return null;
    }

    // ================= ALUMNOS =================
    
    
    public List<UserDTO> obtenerAlumnos(int profesorId) {
        List<UserDTO> alumnos = new ArrayList<>();
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            Gson gson = new Gson();

            // Leer mensaje inicial del servidor (clave pública)
            in.readLine();

            // Enviar petición de alumnos
            out.println(gson.toJson(new SocketData("GET_ALUMNOS", profesorId)));

            // Leer respuesta
            String linea = in.readLine();
            SocketData response = gson.fromJson(linea, SocketData.class);

            if ("ALUMNOS_OK".equals(response.getType())) {
                // Aquí convertimos el data de SocketData en List<UserDTO>
                Type listType = new TypeToken<List<UserDTO>>() {}.getType();
                alumnos = gson.fromJson(gson.toJson(response.getData()), listType);
            } else {
                System.out.println("Error al obtener alumnos: " + response.getData());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ALUMNOS: " + alumnos.size());
        return alumnos;
    }



    // ================= PROFESORES (Lista general) =================
    
    public List<Map<String,Object>> obtenerProfesores() {
        try {
            if (!conectar()) return new ArrayList<>();

            out.println(gson.toJson(new SocketData("GET_PROFESORES", null)));

            String jsonResponse = in.readLine();
            SocketData response = gson.fromJson(jsonResponse, SocketData.class);

            if ("PROFESORES_OK".equals(response.getType())) {
                Type listType = new TypeToken<List<Map<String,Object>>>() {}.getType();
                return gson.fromJson(gson.toJson(response.getData()), listType);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return new ArrayList<>();
    }
    
    // ================= HORARIO PROFESOR =================
    
    public List<HorarioDTO> obtenerHorarioProfesor(int profesorId) {
        try {
            if (!conectar()) return new ArrayList<>();

            // Enviamos solicitud simple con el ID
            out.println(gson.toJson(new SocketData("GET_HORARIO", profesorId)));

            String jsonResponse = in.readLine();
            if (jsonResponse == null) return new ArrayList<>();

            SocketData response = gson.fromJson(jsonResponse, SocketData.class);

            if ("HORARIO_OK".equals(response.getType())) {
                // Convertimos la lista de mapas a Lista de HorarioDTO
                Type listType = new TypeToken<List<HorarioDTO>>() {}.getType();
                return gson.fromJson(gson.toJson(response.getData()), listType);
            } else {
                System.out.println("Error horario: " + response.getData());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // ================= REUNIONES PROFESOR =================
    
    public List<ReunionDTO> obtenerReunionesProfesor(int profesorId) {
        try {
            if (!conectar()) return new ArrayList<>();

            out.println(gson.toJson(new SocketData("GET_REUNIONES", profesorId)));

            String jsonResponse = in.readLine();
            SocketData response = gson.fromJson(jsonResponse, SocketData.class);

            if ("REUNIONES_OK".equals(response.getType())) {
                Type listType = new TypeToken<List<ReunionDTO>>() {}.getType();
                return gson.fromJson(gson.toJson(response.getData()), listType);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return new ArrayList<>();
    }

    // ================= CREAR REUNIÓN =================
    
    public boolean crearReunion(Map<String,Object> datos) {
        try {
            if (!conectar()) return false;

            out.println(gson.toJson(new SocketData("CREAR_REUNION", datos)));

            String jsonResponse = in.readLine();
            SocketData response = gson.fromJson(jsonResponse, SocketData.class);
            
            return "CREAR_REUNION_OK".equals(response.getType());
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    // ================= CAMBIAR ESTADO REUNIÓN =================
    
    public boolean cambiarEstadoReunion(int reunionId, String estado) {
        try {
            if (!conectar()) return false;

            Map<String,Object> data = new HashMap<>();
            data.put("reunionId", reunionId);
            data.put("estado", estado);
            
            out.println(gson.toJson(new SocketData("CAMBIAR_ESTADO_REUNION", data)));

            String jsonResponse = in.readLine();
            SocketData response = gson.fromJson(jsonResponse, SocketData.class);
            
            return "CAMBIAR_ESTADO_REUNION_OK".equals(response.getType());
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    // ================= UTILIDADES RSA =================

    private PublicKey decodificarClavePublica(String keyStr) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(keyStr);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    private String encriptarRSA(String texto) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, serverPublicKey);
        byte[] bytesEncriptados = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }
}