
import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

//Nome do arquivo
public class pokemons {
	
	//Define a UrlBase a ser utilizada
	String baseUrl = "http://pokeapi.azurewebsites.net/";

	@Test
	//Nome do teste
	public void get_All_Pokemon() {
		//Salva o retorno da chamada na varável Response para validação
		Response response = RestAssured.get(baseUrl+"/api/pokemon/list");
		//Testa o status code esperado
		Assert.assertEquals(response.getStatusCode(), 200);
		//Valida se o campo success da requisição retornou 'true'
		Assert.assertEquals(response.jsonPath().getString("success"), "true");
	}
	
	@Test
	//Nome do teste
	public void get_One_Pokemon() {
		//Salva o retorno da chamada na varável Response para validação
		Response response = RestAssured.get(baseUrl+"/api/pokemon/Bulbasaur");
		//Testa o status code esperado
		Assert.assertEquals(response.getStatusCode(), 200);
		//Valida se o campo name da requisição retornou 'Bulbasaur'
		Assert.assertEquals(response.jsonPath().getString("data.name"), "Bulbasaur");
