package com.red.springdemo.dubb2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author red
 * @date 2020-02-21
 */
public class CSFReferenceBean<T> {
//    implements FactoryBean,
//    ApplicationContextAware, InitializingBean, DisposableBean
    private Class<?> interfaceType;

    public CSFReferenceBean(Class<?> interfaceType) {
        this.interfaceType = interfaceType;
    }

    //@Override
    public T getObject(String serviceName) throws Exception {

        InvocationHandler handler = new ServiceProxy(serviceName);
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(),
                new Class<?>[] {interfaceType},handler);

        //这里主要是创建接口对应的实例，便于注入到spring容器中
//        InvocationHandler handler = new ServiceProxy<>(interfaceType);
//        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(),
//                new Class[] {interfaceType},handler);
//        StringBuilder code = new StringBuilder();
//        code.append(generatePackageInfo());
//        code.append(generateImports());
//        code.append(generateClassDeclaration());
//
//        Method[] methods = interfaceType.getMethods();
//        for (Method method : methods) {
//            code.append(generateMethod(method));
//        }
//        code.append("}");
//        String codes = code.toString();
//        System.out.println(codes.toString());
//        codes = codes.trim();
//        Matcher matcher = PACKAGE_PATTERN.matcher(codes);
//        String pkg;
//        if (matcher.find()) {
//            pkg = matcher.group(1);
//        } else {
//            pkg = "";
//        }
//        matcher = CLASS_PATTERN.matcher(codes);
//        String cls;
//        if (matcher.find()) {
//            cls = matcher.group(1);
//        } else {
//            throw new IllegalArgumentException("No such class name in " + code);
//        }
//        String className = pkg != null && pkg.length() > 0 ? pkg + "." + cls : cls;
//        try {
//            return (T)Class.forName(className, true, interfaceType.getClassLoader());
//        } catch (ClassNotFoundException e) {
//            if (!codes.endsWith("}")) {
//                throw new IllegalStateException("The java code not endsWith \"}\", code: \n" + code + "\n");
//            }
//            try {
//                return (T)doCompile(className, codes);
//            } catch (RuntimeException t) {
//                throw t;
//            } catch (Throwable t) {
//                throw new IllegalStateException("Failed to compile class, cause: " + t.getMessage() + ", class: " + className + ", code: \n" + code + "\n, stack: " + ClassUtils.toString(t));
//            }
//        }

        //--------------------------------------------------------


    }
//    private static class StrSrcJavaObject extends SimpleJavaFileObject {
//        private String content;
//        public StrSrcJavaObject(String name, String content) {
//            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
//            this.content = content;
//        }
//        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
//            return content;
//        }
//    }
//
//    public Class<?> doCompile(String name, String source) throws Throwable {
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null, null);
//        StrSrcJavaObject srcObject = new StrSrcJavaObject(name, source);
//        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(srcObject);
//        String flag = "-d";
//        String outDir = "";
//        try {
//            File classPath = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
//            outDir = classPath.getAbsolutePath() + File.separator;
//        } catch (URISyntaxException e1) {
//            e1.printStackTrace();
//        }
//        Iterable<String> options = Arrays.asList(flag, outDir);
//        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, fileObjects);
//        boolean result = task.call();
//        if (result == true) {
//            try {
//                return Class.forName(name);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//
////        CtClassBuilder builder = new CtClassBuilder();
////        builder.setClassName(name);
////
////        // process imported classes
////        Matcher matcher = IMPORT_PATTERN.matcher(source);
////        while (matcher.find()) {
////            builder.addImports(matcher.group(1).trim());
////        }
////
////        // process extended super class
////        matcher = EXTENDS_PATTERN.matcher(source);
////        if (matcher.find()) {
////            builder.setSuperClassName(matcher.group(1).trim());
////        }
////
////        // process implemented interfaces
////        matcher = IMPLEMENTS_PATTERN.matcher(source);
////        if (matcher.find()) {
////            String[] ifaces = matcher.group(1).trim().split("\\,");
////            Arrays.stream(ifaces).forEach(i -> builder.addInterface(i.trim()));
////        }
////
////        // process constructors, fields, methods
////        String body = source.substring(source.indexOf('{') + 1, source.length() - 1);
////        String[] methods = METHODS_PATTERN.split(body);
////        String className = ClassUtils.getSimpleClassName(name);
////        System.out.println(className+"----------------");
////        Arrays.stream(methods).map(String::trim).filter(m -> !m.isEmpty()).forEach(method -> {
////            if (method.startsWith(className)) {
////                builder.addConstructor("public " + method);
////            } else if (FIELD_PATTERN.matcher(method).matches()) {
////                builder.addField("private " + method);
////            } else {
////                builder.addMethod("public " + method);
////            }
////        });
////
////        // compile
////        ClassLoader classLoader = interfaceType.getClassLoader();
////        CtClass cls = builder.build(classLoader);
////        return cls.toClass(classLoader, interfaceType.getClass().getProtectionDomain());
//    }
//
//    private static final Pattern IMPORT_PATTERN = Pattern.compile("import\\s+([\\w\\.\\*]+);\n");
//
//    private static final Pattern EXTENDS_PATTERN = Pattern.compile("\\s+extends\\s+([\\w\\.]+)[^\\{]*\\{\n");
//
//    private static final Pattern IMPLEMENTS_PATTERN = Pattern.compile("\\s+implements\\s+([\\w\\.]+)\\s*\\{\n");
//
//    private static final Pattern METHODS_PATTERN = Pattern.compile("\n(private|public|protected)\\s+");
//
//    private static final Pattern FIELD_PATTERN = Pattern.compile("[^\n]+=[^\n]+;");
//
//    private static final Pattern PACKAGE_PATTERN = Pattern.compile("package\\s+([$_a-zA-Z][$_a-zA-Z0-9\\.]*);");
//
//    private static final Pattern CLASS_PATTERN = Pattern.compile("class\\s+([$_a-zA-Z][$_a-zA-Z0-9]*)\\s+");
//    private static final String CLASSNAME_INVOCATION = "org.apache.dubbo.rpc.Invocation";
//
//    private static final String CODE_PACKAGE = "package %s;\n";
//
//    private static final String CODE_IMPORTS = "import %s;\n";
//
//    private static final String CODE_CLASS_DECLARATION = "public class %s$Adaptive implements %s {\n";
//
//    private static final String CODE_METHOD_DECLARATION = "public %s %s(%s) %s {\n%s}\n";
//
//    private static final String CODE_METHOD_ARGUMENT = "%s arg%d";
//
//    private static final String CODE_METHOD_THROWS = "throws %s";
//
//    private static final String CODE_UNSUPPORTED = "throw new UnsupportedOperationException(\"The method %s of interface %s is not adaptive method!\");\n";
//
//    private static final String CODE_URL_NULL_CHECK = "if (arg%d == null) throw new IllegalArgumentException(\"url == null\");\n%s url = arg%d;\n";
//
//    private static final String CODE_EXT_NAME_ASSIGNMENT = "String extName = %s;\n";
//
//    private static final String CODE_EXT_NAME_NULL_CHECK = "if(extName == null) "
//            + "throw new IllegalStateException(\"Failed to get extension (%s) name from url (\" + url.toString() + \") use keys(%s)\");\n";
//
//    private static final String CODE_INVOCATION_ARGUMENT_NULL_CHECK = "if (arg%d == null) throw new IllegalArgumentException(\"invocation == null\"); "
//            + "String methodName = arg%d.getMethodName();\n";
//
//
//    private static final String CODE_EXTENSION_ASSIGNMENT = "%s extension = (%<s)%s.getExtensionLoader(%s.class).getExtension(extName);\n";
//
//    private static final String CODE_EXTENSION_METHOD_INVOKE_ARGUMENT = "arg%d";
//    /**
//     * generate package info
//     */
//    private String generatePackageInfo() {
//        return String.format(CODE_PACKAGE, interfaceType.getPackage().getName());
//    }
//
//    /**
//     * generate imports
//     */
//    private String generateImports() {
//        return "";
//        //return String.format(CODE_IMPORTS, interfaceType.getClass().getName());
//    }
//    /**
//     * generate class declaration
//     */
//    private String generateClassDeclaration() {
//        return String.format(CODE_CLASS_DECLARATION, interfaceType.getSimpleName(), interfaceType.getCanonicalName());
//    }
//
//    /**
//     * generate method declaration
//     */
//    private String generateMethod(Method method) {
//        String methodReturnType = method.getReturnType().getCanonicalName();
//        String methodName = method.getName();
//        String methodContent = generateMethodContent(method);
//        String methodArgs = generateMethodArguments(method);
//        String methodThrows = generateMethodThrows(method);
//        return String.format(CODE_METHOD_DECLARATION, methodReturnType, methodName, methodArgs, methodThrows, methodContent);
//    }
//
//    /**
//     * generate method throws
//     */
//    private String generateMethodThrows(Method method) {
//        Class<?>[] ets = method.getExceptionTypes();
//        if (ets.length > 0) {
//            String list = Arrays.stream(ets).map(Class::getCanonicalName).collect(Collectors.joining(", "));
//            return String.format(CODE_METHOD_THROWS, list);
//        } else {
//            return "";
//        }
//    }
//
//    /**
//     * generate method arguments
//     */
//    private String generateMethodArguments(Method method) {
//        Class<?>[] pts = method.getParameterTypes();
//        return IntStream.range(0, pts.length)
//                .mapToObj(i -> String.format(CODE_METHOD_ARGUMENT, pts[i].getCanonicalName(), i))
//                .collect(Collectors.joining(", "));
//    }
//
//
//    /**
//     * generate method content
//     */
//    private String generateMethodContent(Method method) {
//        StringBuilder code = new StringBuilder(512);
//        code.append("System.out.println(\"ooooo\"+arg0);");
//        return code.toString();
//            //return generateUnsupported(method);
//    }
//
//    /**
//     * generate code for variable extName null check
//     */
//    private String generateExtNameNullCheck(String[] value) {
//        return String.format(CODE_EXT_NAME_NULL_CHECK, interfaceType.getName(), Arrays.toString(value));
//    }
//
//    /**
//     * generate extName assigment code
//     */
//    private String generateExtNameAssignment(String[] value, boolean hasInvocation) {
//        String defaultExtName="Csf";
//        // TODO: refactor it
//        String getNameCode = null;
//        for (int i = value.length - 1; i >= 0; --i) {
//            if (i == value.length - 1) {
//                if (null != defaultExtName) {
//                    if (!"protocol".equals(value[i])) {
//                        if (hasInvocation) {
//                            getNameCode = String.format("url.getMethodParameter(methodName, \"%s\", \"%s\")", value[i], defaultExtName);
//                        } else {
//                            getNameCode = String.format("url.getParameter(\"%s\", \"%s\")", value[i], defaultExtName);
//                        }
//                    } else {
//                        getNameCode = String.format("( url.getProtocol() == null ? \"%s\" : url.getProtocol() )", defaultExtName);
//                    }
//                } else {
//                    if (!"protocol".equals(value[i])) {
//                        if (hasInvocation) {
//                            getNameCode = String.format("url.getMethodParameter(methodName, \"%s\", \"%s\")", value[i], defaultExtName);
//                        } else {
//                            getNameCode = String.format("url.getParameter(\"%s\")", value[i]);
//                        }
//                    } else {
//                        getNameCode = "url.getProtocol()";
//                    }
//                }
//            } else {
//                if (!"protocol".equals(value[i])) {
//                    if (hasInvocation) {
//                        getNameCode = String.format("url.getMethodParameter(methodName, \"%s\", \"%s\")", value[i], defaultExtName);
//                    } else {
//                        getNameCode = String.format("url.getParameter(\"%s\", %s)", value[i], getNameCode);
//                    }
//                } else {
//                    getNameCode = String.format("url.getProtocol() == null ? (%s) : url.getProtocol()", getNameCode);
//                }
//            }
//        }
//
//        return String.format(CODE_EXT_NAME_ASSIGNMENT, getNameCode);
//    }
//    /**
//     * generate method not annotated with Adaptive with throwing unsupported exception
//     */
//    private String generateUnsupported(Method method) {
//
//        return String.format(CODE_UNSUPPORTED, method, interfaceType.getName());
//    }
//
//
//    /**
//     * @return
//     */
//    private String generateExtensionAssignment() {
//        return String.format(CODE_EXTENSION_ASSIGNMENT, interfaceType.getName(), interfaceType.getClass().getSimpleName(), interfaceType.getName());
//    }
//
//    /**
//     * generate method invocation statement and return it if necessary
//     */
//    private String generateReturnAndInvocation(Method method) {
//        String returnStatement = method.getReturnType().equals(void.class) ? "" : "return ";
//
//        String args = IntStream.range(0, method.getParameters().length)
//                .mapToObj(i -> String.format(CODE_EXTENSION_METHOD_INVOKE_ARGUMENT, i))
//                .collect(Collectors.joining(", "));
//
//        return returnStatement + String.format("extension.%s(%s);\n", method.getName(), args);
//    }
//
//    /**
//     * test if method has argument of type <code>Invocation</code>
//     */
//    private boolean hasInvocationArgument(Method method) {
//        Class<?>[] pts = method.getParameterTypes();
//        return Arrays.stream(pts).anyMatch(p -> CLASSNAME_INVOCATION.equals(p.getName()));
//    }
//
//    /**
//     * generate code to test argument of type <code>Invocation</code> is null
//     */
//    private String generateInvocationArgumentNullCheck(Method method) {
//        Class<?>[] pts = method.getParameterTypes();
//        return IntStream.range(0, pts.length).filter(i -> CLASSNAME_INVOCATION.equals(pts[i].getName()))
//                .mapToObj(i -> String.format(CODE_INVOCATION_ARGUMENT_NULL_CHECK, i, i))
//                .findFirst().orElse("");
//    }
//
//
//
//
//
//
//
//    //@Override
//    public Class<T> getObjectType() {
//        return interfaceType;
//    }
//
//    //@Override
//    public boolean isSingleton() {
//        return true;
//    }
//
//    //@Override
//    public void destroy() throws Exception {
//
//    }
//
//    //@Override
//    public void afterPropertiesSet() throws Exception {
//
//    }
//
//    //@Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//
//    }
}
