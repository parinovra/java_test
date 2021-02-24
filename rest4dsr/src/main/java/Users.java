import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.Set;

public class Users {

    public void usersById {
        try {
            Set<User> users = getUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0;  ; ) {
            System.out.println();
        }
    }

    public Set<User> getUsers() throws IOException {
        String json = getExecutor().execute(Request.Get("http://somehost/api/users.json"))
                .returnContent().asString();
        JsonElement parsed = JsonParser.parseString(json); //analyze string
        JsonElement user_ids = parsed.getAsJsonObject().get("user_ids"); //extract by key 'user_ids' in json
        return new Gson().fromJson(user_ids, new TypeToken<Set<User>>(){}.getType()); //from where, data type
    }

    //for auth-access
    public Executor getExecutor() {
        return Executor.newInstance().auth("auTHkeY123", "password");
    }
}
