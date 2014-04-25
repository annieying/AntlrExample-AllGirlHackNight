public class IdentifierListener extends JavaBaseListener {

	@Override
	public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
		System.out.println(ctx.Identifier());
	}


}
