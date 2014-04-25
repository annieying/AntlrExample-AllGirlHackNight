import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.Token;
import org.apache.commons.io.FileUtils;

public class CodeWordle {
	
	static String identifiers = "";
	
	public static void main(String[] args) {		
		try {
			File dir = new File("./src");
			for( File file : FileUtils.listFiles(dir,new String[]{"java"},true) ) {
				parse(file);
			}
		} catch (IOException e) {
			System.out.println("Something is wrong with the parsing");
		}
	}
	
	public static void parse(File file) throws IOException {
		
		ANTLRFileStream in = new ANTLRFileStream(file.getPath());
		
		// Tokenize the input file
		JavaLexer lexer = new JavaLexer(in);
		
		// Build a parse tree
//		CommonTokenStream tokens = new CommonTokenStream(lexer);
//		JavaParser parser = new JavaParser(tokens);
//		ParserRuleContext tree = parser.javaSnippet(); 
				
		// Print out the identifier tokens
		for( Token t : lexer.getAllTokens() ) {
			if( t.getType()==JavaParser.Identifier ) {
				identifiers += t.getText() + " ";
			}
		}
		FileUtils.write(new File("./result.txt"), identifiers);
	}
}
