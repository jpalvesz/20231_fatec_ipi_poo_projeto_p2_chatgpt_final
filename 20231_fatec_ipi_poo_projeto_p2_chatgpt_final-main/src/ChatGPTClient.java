import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatGPTClient {
  // Tópico 1
  public String criarPerguntaOp1(
    String OPENAI_API_KEY,
    String fraseIngles
  ) throws Exception{

    String prompt = 
    """
      traduza esta frase: %s, para português.
    """.formatted(fraseIngles);
    var requisicao = new ChatGPTRequest(
      "text-davinci-003",
      prompt,
      100,
      1.7,
      2
    );

    var gson = new Gson();

    var requisicaoJSON = gson.toJson(requisicao);

    RequestBody requestBody = 
      RequestBody.create(
          requisicaoJSON, 
          MediaType.parse("application/json")
      );
    
    OkHttpClient httpClient = new OkHttpClient();

    Request request = 
      new Request.Builder()
      .url("https://api.openai.com/v1/completions")
      .addHeader("Media-Type", "application/json")
      .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
      .post(requestBody)
      .build();

      Response response = httpClient.newCall(request).execute();
      ChatGPTResponse chatGPTResponse =
        gson.fromJson(response.body().string(), ChatGPTResponse.class); 
        String completion = 
        chatGPTResponse.getChoices().get(0).getText() + chatGPTResponse.getChoices().get(1).getText();
    return completion;
  }
  // Tópico 2
  public String criarPerguntaOp2(
    String OPENAI_API_KEY,
    String nomeFilme
  ) throws Exception{
    
      String prompt = 
      """
        descreva o filme: %s somente com 3 emojis sem escrita 
      """.formatted(nomeFilme);
      var requisicao = new ChatGPTRequest(
        "text-davinci-003",
        prompt,
        100,
        0,
        1
      );
  
      var gson = new Gson();
  
      var requisicaoJSON = gson.toJson(requisicao);
  
      RequestBody requestBody = 
        RequestBody.create(
            requisicaoJSON, 
            MediaType.parse("application/json")
        );
      
      OkHttpClient httpClient = new OkHttpClient();
  
      Request request = 
        new Request.Builder()
        .url("https://api.openai.com/v1/completions")
        .addHeader("Media-Type", "application/json")
        .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
        .post(requestBody)
        .build();
  
        Response response = httpClient.newCall(request).execute();
        ChatGPTResponse chatGPTResponse =
          gson.fromJson(response.body().string(), ChatGPTResponse.class);
          String completion = 
            chatGPTResponse.getChoices().get(0).getText();
      return completion;
    }

    //Tópico 3
    public String criarPerguntaOp3(
    String OPENAI_API_KEY,
    String explicacaoCrianca
  ) throws Exception{
    
    String prompt = 
    """
      %s? explique de maneira simples para que crianças possam entender. explique com menos de trinta palavras.
    """.formatted(explicacaoCrianca);
    var requisicao = new ChatGPTRequest(
      "text-davinci-003",
      prompt,
      100,
      0,
      1
    );

    var gson = new Gson();

    var requisicaoJSON = gson.toJson(requisicao);

    RequestBody requestBody = 
      RequestBody.create(
          requisicaoJSON, 
          MediaType.parse("application/json")
      );
    
    OkHttpClient httpClient = new OkHttpClient();

    Request request = 
      new Request.Builder()
      .url("https://api.openai.com/v1/completions")
      .addHeader("Media-Type", "application/json")
      .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
      .post(requestBody)
      .build();

      Response response = httpClient.newCall(request).execute();
      ChatGPTResponse chatGPTResponse =
        gson.fromJson(response.body().string(), ChatGPTResponse.class); 
        String completion = 
        chatGPTResponse.getChoices().get(0).getText();
    return completion;
  }
}
