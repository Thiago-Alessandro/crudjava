import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final DBEletronico dbEletronico = new DBEletronico();
    private  static  final DBPessoa dbPessoa = new DBPessoa();

    public static void main(String[] args) {

        do{
            switch (telaInicial()){
                case 1 -> telaCadastro();
                case 2 -> telaExibicao();
                case 3 -> telaPesquisa();
                case 4 -> telaAtualizacao();
                case 5 -> telaExclusao();
                case 0 -> System.exit(0);
                default -> System.out.println("Opcao invalida!");
            }
        } while (true);
    }

    private static int telaInicial(){
        System.out.println("""
                    TELA INICIAL
                1 - Cadastrar
                2 - Exibir
                3 - Pesquisar
                4 - Atualizar/Editar
                5 - Excluir
                0 - Sair
                """);
        return sc.nextInt();
    }

    private static void telaCadastro(){
        int opcao;
        do {
            System.out.println("""
                        TELA DE CADASTRO
                    1 - Cadastrar Eletronico
                    2 - Cadastrar Pessoa
                    0 - voltar
                    """);
            opcao = sc.nextInt();
            switch (opcao){
                case 1 -> cadastrarEletronico();
                case 2 -> cadastrarPessoa();
                case 0 -> {}
                default -> System.out.println("Insira uma opcao válida");
            }
        } while(opcao != 0);
    }

    private static void cadastrarEletronico(){
        int opcao;
        do {
            System.out.println("""
                        NOVO ELETRONICO
                    1 - Televisao
                    2 - Microondas
                    3 - Forno elétrico
                    0 - voltar
                    """);
            opcao = sc.nextInt();
            if(opcao != 0) {
                System.out.println("Insira o preco do Eletronico: ");
                double preco = sc.nextDouble();
                System.out.println("Insira a marca do Eletronico: ");
                String marca = sc.next();
                switch (opcao) {
                    case 1 -> cadastrarTelevisao(preco, marca);
                    case 2 -> cadastrarMicroondas(preco, marca);
                    case 3 -> cadastrarForno(preco, marca);
                    default -> System.out.println("Opcao invalida!");
                }
            }
        }while(opcao != 0);
    }

    private static void cadastrarTelevisao(double preco, String marca){
        System.out.println("Insira a quantia de polegadas da televisao: ");
        double polegadas = sc.nextDouble();
        if(dbEletronico.create(new Televisao(preco, marca, polegadas)) != null){
            System.out.println("Televisao cadastrada com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar televisao, tente novamente!");
        }
    }

    private static void cadastrarMicroondas(double preco, String marca){
        if(dbEletronico.create(new Microondas(preco, marca)) != null){
            System.out.println("Microondas cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar Microondas, tente novamente!");
        }
    }

    private static void cadastrarForno(double preco, String marca){
        System.out.println("Insira a temperatura máxima suportada pelo forno: ");
        double tempMax = sc.nextDouble();
        if(dbEletronico.create(new Forno(preco, marca, tempMax)) != null){
            System.out.println("Forno cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar Forno, tente novamente!");
        }
    }

    private static void cadastrarPessoa(){
        int opcao;
        System.out.println("""
                    NOVA PESSOA
                1 - Aluno
                2 - Funcionario
                3 - Atleta
                0 - voltar
                """);
        opcao = sc.nextInt();
        if(opcao != 0) {
            System.out.println("Insira o nome da pessoa: ");
            String nome = sc.next();
            System.out.println("Insira o cpf da pessoa: ");
            String cpf = sc.next();
            System.out.println("Insira a idade da pessoa: ");
            int idade = sc.nextInt();
            switch (opcao) {
                case 1 -> cadastrarAluno(nome, cpf, idade);
                case 2 -> cadastrarFuncionario(nome, cpf, idade);
                case 3 -> cadastrarAtleta(nome, cpf, idade);
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    private static void cadastrarAluno(String nome, String cpf, int idade){
        System.out.println("Insira a matricula do aluno: ");
        String matrcula = sc.next();
        System.out.println("Insira a instituicao de ensino do aluno: ");
        String instituicaoEnsino = sc.next();
        if(dbPessoa.create(new Aluno(cpf, nome, idade, matrcula, instituicaoEnsino) ) != null){
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar aluno, tente novamente!");
        }
    }

    private static void cadastrarFuncionario(String nome, String cpf, int idade){
        System.out.println("Insira o cadastro do funcionario: ");
        String cadastro = sc.next();
        System.out.println("Insira a profissao do funcionario: ");
        String profissao = sc.next();
        if(dbPessoa.create(new Funcionario(cpf, nome, idade, cadastro, profissao)) != null){
            System.out.println("Funconario cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar funcionario, tente novamente!");
        }
    }

    private static void cadastrarAtleta(String nome, String cpf, int idade){
        System.out.println("Insira a quantia de medalhas do Atleta: ");
        int quantiaMedalhas = sc.nextInt();
        System.out.println("Insira a modalidade do Atleta: ");
        String modalidade = sc.next();
        if(dbPessoa.create(new Atleta(cpf, nome, idade, quantiaMedalhas, modalidade)) != null){
            System.out.println("Atleta cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar atleta, tente novamente!");
        }
    }

    private static void telaExibicao(){
        int opcao;
        do {
            System.out.println("""
                        TELA EXIBIÇÃO
                    1 - Eletronicos
                    2 - Pessoas
                    0 - Voltar
                    """);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> exibirEletronicos();
                case 2 -> exibirPessoas();
                case 0 -> {
                }
                default -> System.out.println("Opcao invalida!");
            }
        }while (opcao != 0);
    }

    private static void exibirEletronicos(){
        System.out.println("""
                    EXIBIR ELETRONICOS
                1 - Microondas
                2 - Televisao
                3 - Forno
                4 - Todos
                """);
        switch (sc.nextInt()){
            case 1 -> exibirMicroondas();
            case 2 -> exibirTelevisoes();
            case 3 -> exibirForno();
            case 4 -> System.out.println(dbEletronico.readAll());
            default -> System.out.println("Opcao Invalida!");
        }
    }

    private static void exibirMicroondas(){
        if(dbEletronico.readAll().size() > 0) {
            for (Eletronico eletronico : dbEletronico.readAll()) {
                if (eletronico instanceof Microondas) {
                    System.out.println(eletronico);
                }
            }
        } else {
            System.out.println("Nenhum Microondas foi cadastrado ainda!");
        }
    }

    private static void exibirTelevisoes(){
        if(dbEletronico.readAll().size() > 0) {
            for (Eletronico eletronico : dbEletronico.readAll()) {
                if (eletronico instanceof Televisao) {
                    System.out.println(eletronico);
                }
            }
        } else {
            System.out.println("Nenhuma televisao foi cadastrada ainda!");
        }
    }

    private static void exibirForno(){
        if(dbEletronico.readAll().size() > 0) {
            for (Eletronico eletronico : dbEletronico.readAll()) {
                if (eletronico instanceof Forno) {
                    System.out.println(eletronico);
                }
            }
        } else {
            System.out.println("Nenhum forno foi cadastrado ainda!");
        }
    }

    private static void exibirPessoas(){
        System.out.println("""
                    EXIBIR Pessoas
                1 - Alunos
                2 - Funcionarios
                3 - Atletas
                4 - Todos
                """);
        switch (sc.nextInt()){
            case 1 -> exibirAlunos();
            case 2 -> exibirFuncionarios();
            case 3 -> exibirAtletas();
            case 4 -> System.out.println(dbPessoa.readAll());
            default -> System.out.println("Opcao Invalida!");
        }
    }

    private static void exibirAlunos(){
        if(dbEletronico.readAll().size() > 0) {
            for (Pessoa pessoa : dbPessoa.readAll()) {
                if (pessoa instanceof Aluno) {
                    System.out.println(pessoa);
                }
            }
        } else {
            System.out.println("Nenhum aluno foi cadastrado ainda!");
        }
    }

    private static void exibirFuncionarios(){
        if(dbEletronico.readAll().size() > 0) {
            for (Pessoa pessoa : dbPessoa.readAll()) {
                if (pessoa instanceof Funcionario) {
                    System.out.println(pessoa);
                }
            }
        } else {
            System.out.println("Nenhum funcionario foi cadastrado ainda!");
        }
    }

    private static void exibirAtletas(){
        if(dbEletronico.readAll().size() > 0) {
            for (Pessoa pessoa : dbPessoa.readAll()) {
                if (pessoa instanceof Atleta) {
                    System.out.println(pessoa);
                }
            }
        } else {
            System.out.println("Nenhum atleta foi cadastrado ainda!");
        }
    }

    private static void telaExclusao(){
        int opcao;
        do {
            System.out.println("""
                        TELA EXLCUSAO
                    1 - Eletronico
                    2 - Funcionario
                    0 - voltar
                    """);

            opcao = sc.nextInt();
            if(opcao != 0) {
                System.out.println("Insira o codigo que deseja excluir: ");
                int cod = sc.nextInt();
                switch (opcao) {
                    case 1 -> excluirEletronico(cod);
                    case 2 -> excluirPessoa(cod);
                    default -> System.out.println("Opcao invalida!");
                }
            }
        }while (opcao != 0);
    }

    private static void excluirEletronico(int codigo){
        if(dbEletronico.delete(dbEletronico.readOne(codigo))){
            System.out.println("Eletronico excluido com sucesso!");

        } else {
            System.out.println("Falha ao excluir eletronico!");
        }
    }

    private static void excluirPessoa(int codigo){
        if(dbPessoa.delete(dbPessoa.readOne(codigo))){
            System.out.println("Eletronico excluido com sucesso!");
        } else {
            System.out.println("Falha ao excluir eletronico!");
        }
    }

    private static void telaPesquisa(){
        int opcao;
        do {
            System.out.println("""
                        PESQUISA
                    1 - Eletronico
                    2 - Pessoa
                    0 - Voltar
                    """);
            opcao = sc.nextInt();
            if(opcao != 0) {
                System.out.println("insira o codigo para pesquisa: ");
                int cod = sc.nextInt();
                switch (opcao) {
                    case 1 -> pesquisarEletronico(cod);
                    case 2 -> pesquisarPessoa(cod);
                    default -> System.out.println("Opcao Invalida");
                }
            }
        } while (opcao != 0);
    }

    private static void pesquisarEletronico(int codigo){
        if(dbEletronico.readOne(codigo) != null){
            System.out.println(dbEletronico.readOne(codigo));
        } else {
            System.out.println("Nao foi encontrado nenhum eletronico com este codigo");
        }
    }

    private static void pesquisarPessoa(int codigo){
        if(dbPessoa.readOne(codigo) != null){
            System.out.println(dbPessoa.readOne(codigo));
        } else {
            System.out.println("Nao foi encontrado nenhuma pessoa com este codigo");
        }
    }

    private static void telaAtualizacao(){
        int opcao;
        do {
            System.out.println("""
                        EDITAR
                    1 - Eletronico
                    2 - Pessoa
                    0 - Voltar
                    """);
            opcao = sc.nextInt();
            if(opcao != 0){
                System.out.println("Insira o codigo do elemento que deseja editar: ");
                int cod = sc.nextInt();
                switch (opcao){
                    case 1 -> editarEletronico(cod);
                    case 2 -> editarPessoa(cod);
                    default -> System.out.println("Opcao invalida");
                }
            }

        } while (opcao != 0);
    }

    private static void editarEletronico(int cod){
        Eletronico eletronicoAEditar = dbEletronico.readOne(cod);
        if (eletronicoAEditar != null) {
            System.out.println("Insira o novo preco: ");
            eletronicoAEditar.setPreco(sc.nextDouble());
            System.out.println("Insira a nova marca: ");
            eletronicoAEditar.setMarca(sc.next());

            if(eletronicoAEditar instanceof Microondas){
                System.out.println("Insira a nova potencia: ");
                ((Microondas)eletronicoAEditar).setPotencia(sc.nextInt());

            } else if (eletronicoAEditar instanceof Televisao){
                System.out.println("Insira a nova quantia de polegadas: ");
                ((Televisao)eletronicoAEditar).setPolegadas(sc.nextDouble());
            } else if (eletronicoAEditar instanceof Forno){
                System.out.println("Insira o novo valor maximo da temperatura do forno: ");
                ((Forno)eletronicoAEditar).setTemperaturaMax(sc.nextDouble());
            }
            if(dbEletronico.update(eletronicoAEditar) != null){
                System.out.println("Eletronico atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar eletronico");
            }
        } else {
            System.out.println("Codigo de eletronico não encontrado");
        }
    }

    private static void editarPessoa(int cod){
        Pessoa pessoaAEditar = dbPessoa.readOne(cod);
        if (pessoaAEditar != null) {
            System.out.println("Insira o novo nome: ");
            pessoaAEditar.setNome(sc.next());
            System.out.println("Insira a nova idade: ");
            pessoaAEditar.setIdade(sc.nextInt());
            System.out.println("Insira o novo cpf: ");
            pessoaAEditar.setCpf(sc.next());

            if(pessoaAEditar instanceof Aluno){
                System.out.println("Insira a nova matricula: ");
                ((Aluno)pessoaAEditar).setMatricula(sc.next());
                System.out.println("Insira a nova instituicao de ensino: ");
                ((Aluno)pessoaAEditar).setInstituicaoEnsino(sc.next());

            } else if (pessoaAEditar instanceof Funcionario){
                System.out.println("Insira o novo cadastro: ");
                ((Funcionario)pessoaAEditar).setCadastro(sc.next());
                System.out.println("Insira a nova profissao: ");
                ((Funcionario)pessoaAEditar).setProfissao(sc.next());
            } else if (pessoaAEditar instanceof Atleta){
                System.out.println("Insira a nova quantia de medalhas do atleta: ");
                ((Atleta)pessoaAEditar).setQuantiaMedalhas(sc.nextInt());
                System.out.println("Inisra a nova modalidade do atleta: ");
                ((Atleta)pessoaAEditar).setModalidade(sc.next());
            }
            if(dbPessoa.update(pessoaAEditar) != null){
                System.out.println("Pessoa atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar pessoa");
            }
        } else {
            System.out.println("Codigo de pessoa não encontrado");
        }
    }

}
