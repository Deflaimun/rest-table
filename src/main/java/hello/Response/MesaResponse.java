package hello.Response;

public class MesaResponse {

    private String mensagem;
    private boolean sucesso;
    private String codigo;
    private long qtdMesasAFrente;
    private int idMesa;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public long getQtdMesasAFrente() {
        return qtdMesasAFrente;
    }

    public void setQtdMesasAFrente(long qtdMesasAFrente) {
        this.qtdMesasAFrente = qtdMesasAFrente;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
}
