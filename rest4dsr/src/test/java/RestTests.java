import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends Users {

    @Test
    public void testPutUser() throws IOException {

        Set<User> oldUsers = getUsers();
        User newUser = new User().withName("Jane").withAge("32"); //call constructor
        int userId = createUser(newUser);
        Set<User> newUsers = getUsers();
        oldUsers.add(newUser.withId(userId));
        assertEquals(newUsers, oldUsers);
    }

//    private Set<User> getUsers() throws IOException {
//        String json = getExecutor().execute(Request.Get("http://somehost/api/users.json"))
//                .returnContent().asString();
//        JsonElement parsed = JsonParser.parseString(json); //analyze string
//        JsonElement user_ids = parsed.getAsJsonObject().get("user_ids"); //extract by key 'user_ids' in json
//        return new Gson().fromJson(user_ids, new TypeToken<Set<User>>(){}.getType()); //from where, data type
//    }

//    //for auth-access
//    private Executor getExecutor() {
//        return Executor.newInstance().auth("auTHkeY123", "password");
//    }

    private int createUser(User newUser) throws IOException {
        String json = getExecutor().execute(Request.Put("http://somehost/api/user/" + id ".json") //add max id!!!!
                .bodyForm(new BasicNameValuePair("name", newUser.getName()),
                          new BasicNameValuePair("age", newUser.getAge())))
                .returnContent().asString();
        JsonElement parsed = JsonParser.parseString(json);
        return parsed.getAsJsonObject().get("id").getAsInt();
    }


    @Test
    public void testDeleteUser() throws IOException {

        Set<User> oldUsers = getUsers();
        int userId = deleteUser();
        Set<User> newUsers = getUsers();
        oldUsers.remove(userId);
        assertEquals(newUsers, oldUsers);
    }

    private int deleteUser() {
        String json = getExecutor().execute(Request.Delete("http://somehost/api/user/" + id + ".json")
                .returnContent().asString();
        JsonElement parsed = JsonParser.parseString(json); //analyze string
        return parsed.getAsJsonObject().get("id").getAsInt();
    }
}