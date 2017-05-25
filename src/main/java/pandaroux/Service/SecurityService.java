package pandaroux.Service;

import org.springframework.stereotype.Service;
import pandaroux.Entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityService {

    public static String getRedirectionLink(User user) throws Exception {
        return caseRole(user.getRole().getName());
    }

    public static String getRedirectionLink(Map user) throws Exception {
        return caseRole((String) user.get("role_name"));
    }

    private static String caseRole(String role_name) throws Exception {

        switch (role_name) {
            case "eleve":
                return "/student/index";
            case "pof":
                return "/teacher/index";
            // case "administration":
            // return "/admin/index";
            default:
                throw (new Exception("role not found"));
        }
    }

    public static String fireWall(String path, HttpServletRequest request) {

        if (request.getSession(true).getAttribute("user") == null) {
            return "redirect:/login";
        } else {
            return path;
        }
    }

    public static String loginFireWall(String path, HttpServletRequest request) throws Exception {

        Map user = (Map) request.getSession(true).getAttribute("user");

        if (user == null) {
            return path;
        }

        return "redirect:" + getRedirectionLink(user);
    }

    public static void addUserToSession(User user, HttpServletRequest request) {

        Map userSession = new HashMap() {{
            put("id", user.getId());
            put("name", user.getName());
            put("first_name", user.getFirst_name());
            put("role_name", user.getRole().getName());
            put("role_id", user.getRole().getId());
        }};

        request.getSession(true).setAttribute("user", userSession);
    }

    public static int getUserId(HttpServletRequest request) throws Exception {

        Map user = (Map) request.getSession(true).getAttribute("user");

        if (user == null) {
            throw (new Exception("User not conected"));
        }

        return (int) user.get("id");

    }

    public static boolean hasRole(String role_name, HttpServletRequest request) throws Exception {

        Map user = (Map) request.getSession(true).getAttribute("user");

        if (user == null) {
            throw (new Exception("User not conected"));
        }

        String role_nameSession = (String) user.get("role_name");

        return role_nameSession.equals(role_name);
    }

    public static boolean hasRole(int role_id, HttpServletRequest request) throws Exception {

        Map user = (Map) request.getSession(true).getAttribute("user");

        if (user == null) {
            throw (new Exception("User not conected"));
        }

        int role_idSession = (int) user.get("role_id");

        return role_idSession == role_id;
    }

    public static boolean isConnected(HttpServletRequest request) {

        return request.getSession(true).getAttribute("user") != null;
    }
}
