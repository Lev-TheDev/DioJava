package br.com.dio;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

@SupportedAnnotationTypes("br.com.dio.Builder")
@SupportedSourceVersion(javax.lang.model.SourceVersion.RELEASE_21)
public class BuilderProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            for (var element : roundEnv.getElementsAnnotatedWith(annotation)) {
                Map<String, TypeMirror> fields = element.getEnclosedElements().stream()
                        .filter(e -> e.getKind() == ElementKind.FIELD)
                        .collect(toMap(e -> e.getSimpleName().toString(), Element::asType));
                var packageName = processingEnv.getElementUtils().getPackageOf(element).toString();
                var className = element.getSimpleName().toString();
                var builderName = className + "Builder";

                var typeSpec = new BuilderGenerator().create(packageName, className, builderName, fields);
                var javaFile = com.squareup.javapoet.JavaFile.builder(packageName, typeSpec)
                        .indent("    ")
                        .build();
                try(var out = new PrintWriter(processingEnv.getFiler()
                        .createSourceFile(builderName).openWriter())) {
                    out.write(javaFile.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);

                }
            }
        }
        return true;
    }
}
