open class Pessoa(nome: String = "", dataNascimento: String = "", altura: Float = 0f, anoAtual: Int) {
    var nome: String;
    var dataNascimento: String;
    var altura: Float;
    private var idade: Int;

    init {
        this.nome = nome
        this.altura = altura
        this.dataNascimento = dataNascimento;
        this.idade = calcularIdade(anoAtual);
    }

    fun getIdade(): Int {
        return this.idade;
    }

    fun calcularIdade(anoAtual: Int): Int {
        var arrayDate = dataNascimento.split("/");
        var anoNascimento = arrayDate[2].toInt();

        return anoAtual - anoNascimento;
    }

    override fun toString() = "$nome ($dataNascimento, $altura)";
}

class Agenda() {
    var pessoaList: ArrayList<Pessoa>

    init {
        this.pessoaList = ArrayList();
    }

    fun armazenaPessoa(pessoa: Pessoa) {
        this.pessoaList.add(pessoa);
    }

    fun removerPessoa(nome: String) {
        var i: Int? = buscarPessoa(nome);
        if (i == null) {
            println("Essa pessoa não está cadastrada na lista.");
        } else {
            this.pessoaList.removeAt(i);
        }
    }

    fun printAgenda() {
        println(pessoaList.toString());
    }

    fun printPessoa(index: Int) {
        println(pessoaList.get(index));
    }

    fun buscarPessoa(nome: String): Int? {
        for(i in pessoaList) {
            if (i.nome.equals(nome)) {
                return pessoaList.indexOf(i);
            }
        }

        return null;
    }
}

class Funcionario:Pessoa {
    var salario: Float;
    constructor(nome: String = "", dataNascimento: String = "", altura: Float = 0f, anoAtual: Int, salario: Float) : super(nome, dataNascimento, altura, anoAtual) {
        this.salario = salario;
    }
}

fun main() {
    var p1: Pessoa

    p1 = Pessoa("Gustavo", "02/09/1999", 1.76f, 2021);
    println(p1.nome);
    println(p1.dataNascimento);
    println(p1.altura);
    println(p1.toString());
    println(p1.getIdade());

    var p2: Pessoa
    p2 = Pessoa("Taniro", "02/06/1988", 1.76f, 2021);

    var p3: Pessoa
    p3 = Pessoa("Tads", "01/01/2011", 1.90f, 2021);

    var listaPessoa: Agenda;
    listaPessoa = Agenda();

    listaPessoa.armazenaPessoa(p1);
    listaPessoa.armazenaPessoa(p2);
    listaPessoa.armazenaPessoa(p3);

    listaPessoa.printAgenda();
    listaPessoa.printPessoa(0);
    listaPessoa.printPessoa(1);
    listaPessoa.printPessoa(2);

    var funcionario: Funcionario;

    funcionario = Funcionario("Jusiscleiton", "29/12/1998", 1.68f, 2021, 5000f);

    print(funcionario.salario);


}