package servicos;

import hello.Response.MesaResponse;
import modelo.Cliente;
import modelo.Mesa;

import java.util.*;

public class ServicoGerenciadorMesa {

    private Map<Integer,Mesa> listaMesas2 = new HashMap<>();
    private Map<Integer,Mesa> listaMesas4 = new HashMap<>();
    private Map<Integer,Mesa> listaMesas10 = new HashMap<>();

    private Queue<Cliente> listaEsperaMesas2 = new LinkedList<>();
    private Queue<Cliente> listaEsperaMesas4 = new LinkedList<>();
    private Queue<Cliente> listaEsperaMesas10 = new LinkedList<>();



    public ServicoGerenciadorMesa() {
        //estou assumindo a situação que o restaurante nao pode juntar mesas
        Mesa mesa21 = new Mesa(3, 2, false);
        Mesa mesa41 = new Mesa(1, 4, false);
        Mesa mesa42 = new Mesa(2, 4, false);
        Mesa mesa101 = new Mesa(4, 10, false);
        listaMesas2.put(mesa21.getId(),mesa21);
        listaMesas4.put(mesa41.getId(),mesa41);
        listaMesas4.put(mesa42.getId(),mesa42);
        listaMesas10.put(mesa101.getId(),mesa101);
    }


    public MesaResponse alocaMesa(Long qtd, Long idCliente) {
        MesaResponse response = new MesaResponse();
        Cliente cliente = new Cliente(idCliente);
        if (qtd <= 2) {
            for (Mesa m : listaMesas2.values()) {
                if (m.isNotPreenchida()) {
                    m.setPreenchida(true);
                    m.setCliente(cliente);
                    response.setCodigo("M" + m.getId() + "C" + idCliente);
                    response.setSucesso(true);
                    response.setMensagem("Mesa reservada com sucesso");
                    response.setCliente(cliente);
                    return response;
                }
            }
            response.setQtdMesasAFrente(listaEsperaMesas2.size());
            listaEsperaMesas2.add(new Cliente(idCliente));
            response.setMensagem("Todas as mesas estão cheias. Cliente colocado numa fila");
            response.setIdMesa(-1);
        } else if (qtd <= 4) {
            for (Mesa m : listaMesas4.values()) {
                if (m.isNotPreenchida()) {
                    m.setPreenchida(true);
                    m.setCliente(cliente);
                    response.setCodigo("M" + m.getId() + "C" + idCliente);
                    response.setSucesso(true);
                    return response;
                }
            }
            response.setQtdMesasAFrente(listaEsperaMesas4.size());
            listaEsperaMesas4.add(new Cliente(idCliente));
            response.setMensagem("Todas as mesas estão cheias. Cliente colocado numa fila");
            response.setIdMesa(-1);
        } else if (qtd <= 10) {
            for (Mesa m : listaMesas10.values()) {
                if (m.isNotPreenchida()) {
                    m.setPreenchida(true);
                    m.setCliente(cliente);
                    response.setCodigo("M" + m.getId() + "C" + idCliente);
                    response.setSucesso(true);
                    return response;
                }
            }
            response.setQtdMesasAFrente(listaEsperaMesas10.size());
            listaEsperaMesas10.add(new Cliente(idCliente));
            response.setMensagem("Todas as mesas estão cheias. Cliente colocado numa fila");
            response.setIdMesa(-1);

        } else {
            response.setMensagem("Não foi possível encontrar uma mesa");
        }

        return response;

    }

    public MesaResponse liberaMesa(Mesa m) {
        MesaResponse response = new MesaResponse();
        String mensagem;

        if (m.getQuantidadePessoas() == 2) {


            listaMesas2.get(m.getId()).setPreenchida(false);
            listaMesas2.get(m.getId()).setCliente(null);
        } else if (m.getQuantidadePessoas() == 4) {
            listaMesas4.get(m.getId()).setPreenchida(false);
            listaMesas4.get(m.getId()).setCliente(null);
        } else if (m.getQuantidadePessoas() == 10) {
            listaMesas10.get(m.getId()).setPreenchida(false);
            listaMesas10.get(m.getId()).setCliente(null);
        }


        mensagem = "Mesa " + m.getId() + " liberada com sucesso.";
        Cliente c = preencheNovaMesa(m);
        if(c != null){
            mensagem += "Chame o cliente " +  c.getId();

        }

        if(m.getQuantidadePessoas() ==2 ){
            listaMesas2.replace(m.getId(),m);

        }
        else if(m.getQuantidadePessoas() ==4){
            listaMesas4.replace(m.getId(),m);

        }
        else if(m.getQuantidadePessoas() ==10){
            listaMesas10.replace(m.getId(),m);

        }
        response.setMensagem(mensagem);
        response.setSucesso(true);
        return response;
    }

    private Cliente preencheNovaMesa(Mesa m) {
        if(!listaEsperaMesas2.isEmpty()){
            m.setCliente(listaEsperaMesas2.peek());
            m.setPreenchida(true);
            return listaEsperaMesas2.poll();

        }

        if(!listaEsperaMesas4.isEmpty()){
            m.setCliente(listaEsperaMesas4.peek());
            m.setPreenchida(true);
            return listaEsperaMesas4.poll();

        }

        if(!listaEsperaMesas10.isEmpty()){
            m.setCliente(listaEsperaMesas10.peek());
            m.setPreenchida(true);
            return listaEsperaMesas10.poll();

        }
        return null;

    }

    public MesaResponse verificaDisponibilidade(Long qtd,Long idCliente) {
        MesaResponse response = new MesaResponse();
        String mensagem;

        if (qtd <= 2) {
            for (Mesa m: listaMesas2.values()) {
                if(m.getCliente().getId() == idCliente){
                    response.setCodigo("M" + m.getId() + "C" + idCliente);
                    response.setSucesso(true);
                    mensagem = "Mesa " +m.getId() + " liberada.";
                    response.setMensagem(mensagem);
                    return response;
                }
            }

        } else if (qtd <= 4) {

            for (Mesa m: listaMesas4.values()) {
                if(m.getCliente().getId() == idCliente){
                    response.setCodigo("M" + m.getId() + "C" + idCliente);
                    response.setSucesso(true);
                    mensagem = "Mesa " +m.getId() + " liberada.";
                    response.setMensagem(mensagem);
                    return response;
                }
            }

        } else if (qtd <= 10) {

            for (Mesa m: listaMesas10.values()) {
                if(m.getCliente().getId() == idCliente){
                    response.setCodigo("M" + m.getId() + "C" + idCliente);
                    response.setSucesso(true);
                    mensagem = "Mesa " +m.getId() + " liberada.";
                    response.setMensagem(mensagem);
                    return response;
                }
            }
        }

        Object[] cArray2 = listaEsperaMesas2.toArray();
        Object[] cArray4 = listaEsperaMesas4.toArray();
        Object[] cArray10 = listaEsperaMesas10.toArray();
        Cliente c;
        long posicaoFila=0;

        for (int i = 0; i < cArray2.length; i++) {
            c = (Cliente )cArray2[i];
            if (c.getId() ==idCliente){
                posicaoFila = i;
            }
        }

        for (int i = 0; i < cArray4.length; i++) {
            c = (Cliente )cArray4[i];
            if (c.getId() ==idCliente){
                posicaoFila = i;
            }
        }

        for (int i = 0; i < cArray10.length; i++) {
            c = (Cliente )cArray10[i];
            if (c.getId() ==idCliente){
                posicaoFila = i;
            }
        }

        response.setQtdMesasAFrente(posicaoFila);
        return response;
    }
}
