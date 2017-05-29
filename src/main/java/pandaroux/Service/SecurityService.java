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
            case "eleve":   // student
                return "/student/index";
            case "prof":     // teacher
                return "/teacher/index";
            // case "administration":
            // return "/admin/index";
            default:
                throw (new Exception("role not found"));
        }
    }

    public static String fireWall(String path, HttpServletRequest request) {

        Map user = (Map) request.getSession(true).getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        return path;
    }

    public static String fireWall(String path, HttpServletRequest request, String[] roles_names) throws Exception {

        Map user = (Map) request.getSession(true).getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        String role_nameSession = (String) user.get("role_name");

        // if he has the role to see this page
        if (!containsRoleName(roles_names, role_nameSession)) {
            return "redirect:" + caseRole(role_nameSession);
        }

        return path;
    }

    private static boolean containsRoleName(String[] roles_names, String role_name) {

        for (String roleNameLoop : roles_names) {
            if(roleNameLoop.equals(role_name)) return true;
        }

        return false;
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
            put("id_isep", user.getId_isep());
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

    public static String logout(String login, HttpServletRequest request) {

        request.getSession(true).removeAttribute("user");

        return login;
    }
}
