package modelo;

public class Mesa {

    private int id;
    private long quantidadePessoas;
    private boolean preenchida;
    private Cliente cliente;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(long quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public boolean isPreenchida() {
        return preenchida;
    }

    public boolean isNotPreenchida() {
        return preenchida;
    }

    public void setPreenchida(boolean preenchida) {
        this.preenchida = preenchida;
    }

    public Mesa(int id, long quantidadePessoas, boolean preenchida) {
        this.id = id;
        this.quantidadePessoas = quantidadePessoas;
        this.preenchida = preenchida;
    }

    public Mesa(int id, long quantidadePessoas) {
        this.id = id;
        this.quantidadePessoas = quantidadePessoas;
    }

    public Mesa() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
