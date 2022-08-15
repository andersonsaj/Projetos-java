import java.util.Optional;

public class ExemploOptionalEstado {

	public static void main(String[] args) {
		Optional<String> optStr = Optional.of("Valor presente");
		
		System.out.println("Valor opcional que est� presente");
		optStr.ifPresentOrElse(System.out::println, () -> System.out.println("n�o presente"));
		
		Optional<String> optNull = Optional.ofNullable(null);
		
		System.out.println("Valor opcional que n�o est� presente");
		optNull.ifPresentOrElse(System.out::println, () -> System.out.println("null = n�o presente") );
		
		Optional<String> emptyOpt = Optional.empty();
		System.out.println("Valor optional que n�o est� presente");
		emptyOpt.ifPresentOrElse(System.out::println, () -> System.out.println("empty = N�O PRESENTE"));
		
			Optional<String> optNullErro = Optional.of(null);
			System.out.println("Valor opcional que lan�a erro NullPointerException");
			optNullErro.ifPresentOrElse(System.out::println, () -> System.out.println("Erro = n�o presente"));
		
	}

}
