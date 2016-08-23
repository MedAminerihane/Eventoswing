package GUI;

import DaoClasse.ClientDao;
import DaoInterface.IClientDao;
import Entites.Client;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.Parameter;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.Url;
import com.restfb.types.User;

@SuppressWarnings("deprecation")
public class GraphReaderExample {
  private final FacebookClient facebookClient;


//  public static void main(String[] args) {
//      //Acess Token
//    new GraphReaderExample("CAALF91CGxmEBAEyvZCIWdEKCGamTJN1Lk1D6A1EcCBHEzZCx04K8oXaoYA2hD2cs5YOcIZCmmGugfZCcDvOhZAPG9KGPuJ1uMwygdX0V0bY6fzkntivd8qef7Sj7SDP9Qj7AUYfFvjY58G3G6DORi5T6lVjMRdRMEt8j6NPbUGlTDuWPSKfxL2ycXlDySKDcPyQX4BFcZBhexIUfJ3r0df").runEverything();
//  }

  GraphReaderExample(String accessToken) {
    facebookClient = new DefaultFacebookClient(accessToken);
  }

  void runEverything() {
      fetchObject();
//    fetchObjects();
//    fetchObjectsAsJsonObject();
//    fetchConnections();
//    fetchDifferentDataTypesAsJsonObject();
//    query();
//    multiquery();
//    search();
//    metadata();
//    paging();
//    selection();
//    parameters();
//    rawJsonResponse();
  }

  void fetchObject() {
    out.println("* Fetching single objects *");

    User user = facebookClient.fetchObject("me", User.class);
    Page page = facebookClient.fetchObject("cocacola", Page.class);
    Client client = new Client();
    IClientDao clientDAO = new ClientDao();
    

    out.println("Name: " + user.getName());
    out.println("Username: " + user.getUsername());
    out.println("Email: " + user.getEmail());
    out.println("ID Facebook: " + user.getId());
    out.println("About: " + user.getAbout());
    out.println("Birthday: " + user.getBirthday());
    out.println("Locale: " + user.getLocale());
    out.println("HometownName: " + user.getHometownName());
    out.println("Political: " + user.getPolitical());
    out.println("Quotes: " + user.getQuotes());
    out.println("Quotes: " + user.getBirthdayAsDate());
    out.println("Religion: " + user.getReligion());
    out.println("webSite: " + user.getWebsite());
    out.println("Page likes: " + page.getLikes());
    
   // client.setAge(2015-Integer.parseInt(user.getAge()));
     client.setAge(2015-Integer.parseInt((user.getBirthday().substring(6, 10))));
     client.setAdresse("Ariana");
     client.setNom(user.getLastName());
     client.setPrenom(user.getFirstName());
     client.setMail(user.getEmail());
     client.setPassword("esprit");
     client.setTel(22543361);
     client.setNature(1);
     client.setCin(4826201);
     clientDAO.insertClient(client);
     System.out.println("inscription effectué !!!");
    
    
    
  }

  void fetchObjectsAsJsonObject() {
    out.println("* Fetching multiple objects at once as a JsonObject *");

    List<String> ids = new ArrayList<String>();
    ids.add("btaylor");
    ids.add("http://www.imdb.com/title/tt0117500/");

    // Make the API call
    JsonObject results = facebookClient.fetchObjects(ids, JsonObject.class);

    // Pull out JSON data by key and map each type by hand.
    JsonMapper jsonMapper = new DefaultJsonMapper();
    User user = jsonMapper.toJavaObject(results.getString("btaylor"), User.class);
    Url url = jsonMapper.toJavaObject(results.getString("http://www.imdb.com/title/tt0117500/"), Url.class);

    out.println("User is " + user);
    out.println("URL is " + url);
  }

  void fetchObjects() {
    out.println("* Fetching multiple objects at once *");

    FetchObjectsResults fetchObjectsResults =
        facebookClient.fetchObjects(Arrays.asList("me", "cocacola"), FetchObjectsResults.class);

    out.println("User name: " + fetchObjectsResults.me.getName());
    out.println("Page likes: " + fetchObjectsResults.page.getLikes());
  }

  void fetchDifferentDataTypesAsJsonObject() {
    out.println("* Fetching different types of data as JsonObject *");

    JsonObject btaylor = facebookClient.fetchObject("btaylor", JsonObject.class);
    out.println(btaylor.getString("name"));

    JsonObject photosConnection = facebookClient.fetchObject("me/photos", JsonObject.class);
    JsonArray photosConnectionData = photosConnection.getJsonArray("data");

    if (photosConnectionData.length() > 0) {
      String firstPhotoUrl = photosConnectionData.getJsonObject(0).getString("source");
      out.println(firstPhotoUrl);
    }

    String query = "SELECT uid, name FROM user WHERE uid=220439 or uid=7901103";
    List<JsonObject> queryResults = facebookClient.executeQuery(query, JsonObject.class);

    if (queryResults.size() > 0)
      out.println(queryResults.get(0).getString("name"));
  }
  
  public static class FetchObjectsResults {
    @Facebook
    User me;

    @Facebook(value = "cocacola")
    Page page;
  }

  void fetchConnections() {
    out.println("* Fetching connections *");

    Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
    Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);

    out.println("Count of my friends: " + myFriends.getData().size());

    if (myFeed.getData().size() > 0)
      out.println("First item in my feed: " + myFeed.getData().get(0).getMessage());
  }

  void query() {
    out.println("* FQL Query *");

    List<FqlUser> users =
        facebookClient.executeQuery("SELECT uid, name FROM user WHERE uid=220439 or uid=7901103", FqlUser.class);

    out.println("User: " + users);
  }

  void multiquery() {
    out.println("* FQL Multiquery *");

    Map<String, String> queries = new HashMap<String, String>();
    queries.put("users", "SELECT uid, name FROM user WHERE uid=220439 OR uid=7901103");
    queries.put("likers", "SELECT user_id FROM like WHERE object_id=122788341354");

    MultiqueryResults multiqueryResults = facebookClient.executeMultiquery(queries, MultiqueryResults.class);

    out.println("Users: " + multiqueryResults.users);
    out.println("People who liked: " + multiqueryResults.likers);
  }

  public static class FqlUser {
    @Facebook
    String uid;

    @Facebook
    String name;

    @Override
    public String toString() {
      return format("%s (%s)", name, uid);
    }
  }

  public static class FqlLiker {
    @Facebook("user_id")
    String userId;

    @Override
    public String toString() {
      return userId;
    }
  }

  /**
   * Holds results from a "multiquery" call.
   */
  public static class MultiqueryResults {
    @Facebook
    List<FqlUser> users;

    @Facebook
    List<FqlLiker> likers;
  }

  void search() {
    out.println("* Searching connections *");

    Connection<Post> publicSearch =
        facebookClient.fetchConnection("search", Post.class, Parameter.with("q", "ben foulen"),
          Parameter.with("type", "post"));

    Connection<User> targetedSearch =
        facebookClient.fetchConnection("me/home", User.class, Parameter.with("q", "foulen"),
          Parameter.with("type", "user"));

    if (publicSearch.getData().size() > 0)
      out.println("Public search: " + publicSearch.getData().get(0).getMessage());

    out.println("Posts on my wall by friends named Mark: " + targetedSearch.getData().size());
  }

  void metadata() {
    out.println("* Metadata *");

    User userWithMetadata = facebookClient.fetchObject("me", User.class, Parameter.with("metadata", 1));

    out.println("User metadata: has albums? " + userWithMetadata.getMetadata().getConnections().hasAlbums());
  }

  void paging() {
    out.println("* Paging support *");

    Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
    Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class, Parameter.with("limit", 100));

    out.println("Count of my friends: " + myFriends.getData().size());

    if (myFeed.getData().size() > 0)
      out.println("First item in my feed: " + myFeed.getData().get(0));

    for (List<Post> myFeedConnectionPage : myFeed)
      for (Post post : myFeedConnectionPage)
        out.println("Post from my feed: " + post);
  }

  void selection() {
    out.println("* Selecting specific fields *");

    User user = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "id,name"));

    out.println("User name: " + user.getName());
  }

  void parameters() {
    out.println("* Parameter support *");

    Date oneWeekAgo = new Date(currentTimeMillis() - 1000L * 60L * 60L * 24L * 7L);

    Connection<Post> filteredFeed =
        facebookClient.fetchConnection("me/feed", Post.class, Parameter.with("limit", 3),
          Parameter.with("until", "yesterday"), Parameter.with("since", oneWeekAgo));

    out.println("Filtered feed count: " + filteredFeed.getData().size());
  }

  void rawJsonResponse() {
    out.println("* Raw JSON *");
    out.println("User object JSON: " + facebookClient.fetchObject("me", String.class));
  }
}