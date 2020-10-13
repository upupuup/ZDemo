package com.anno;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * @Author:         jiangzhihong
 * @CreateDate:     2020/10/13 10:48
 */
@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameScannerProcessor extends AbstractProcessor {
	@Override
	public void init(ProcessingEnvironment processingEnv){
		super.init(processingEnv);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param annotations
	 * @param roundEnv
	 */
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		if(!roundEnv.processingOver()){
			for(Element element : roundEnv.getElementsAnnotatedWith(NameScanner.class)){
				String name = element.getSimpleName().toString();
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "element name: " + name);
			}
		}
		return false;
	}
}
