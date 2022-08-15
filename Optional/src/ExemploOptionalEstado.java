import java.util.Optional;

public class ExemploOptionalEstado {

	public static void main(String[] args) {
		Optional<String> optStr = Optional.of("Valor presente");
		
		System.out.println("Valor opcional que está presente");
		optStr.ifPresentOrElse(System.out::println, () -> System.out.println("não presente"));
		
		Optional<String> optNull = Optional.ofNullable(null);
		
		System.out.println("Valor opcional que não está presente");
		optNull.ifPresentOrElse(System.out::println, () -> System.out.println("null = não presente") );
		
		Optional<String> emptyOpt = Optional.empty();
		System.out.println("Valor optional que não está presente");
		emptyOpt.ifPresentOrElse(System.out::println, () -> System.out.println("empty = NÃO PRESENTE"));
		
			Optional<String> optNullErro = Optional.of(null);
			System.out.println("Valor opcional que lança erro NullPointerException");
			optNullErro.ifPresentOrElse(System.out::println, () -> System.out.println("Erro = não presente"));
		
	}

}
