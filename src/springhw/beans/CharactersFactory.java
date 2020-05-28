package springhw.beans;

public class CharactersFactory{
	public Characters getCharactersExt(String role) {
		return new Characters(role);
	}
}
