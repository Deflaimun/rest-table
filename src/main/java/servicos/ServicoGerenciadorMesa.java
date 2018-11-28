package servicos;

import hello.Response.MesaResponse;
import modelo.Cliente;
import modelo.Mesa;

import java.util.ArrayList;
import java.util.List;

public class ServicoGerenciadorMesa {

    private List<Mesa> listaMesas2 = new ArrayList<>();
    private List<Mesa> listaMesas4 = new ArrayList<>();
    private List<Mesa> listaMesas10 = new ArrayList<>();

    private List<Cliente> listaEsperaMesas2 = new ArrayList<>();
    private List<Cliente> listaEsperaMesas4 = new ArrayList<>();
    private List<Cliente> listaEsperaMesas10 = new ArrayList<>();


    public ServicoGerenciadorMesa() {
        //estou assumindo a situação que o restaurante nao pode juntar mesas
        Mesa mesa21 = new Mesa(3, 2, false);
        Mesa mesa41 = new Mesa(1, 4, false);
        Mesa mesa42 = new Mesa(2, 4, false);
        Mesa mesa101 = new Mesa(4, 10, false);
        listaMesas2.add(mesa21);
        listaMesas4.add(mesa41);
        listaMesas4.add(mesa42);
        listaMesas10.add(mesa101);
    }


    public MesaResponse alocaMesa(Long qtd, Long idCliente) {
        MesaResponse response = new MesaResponse();
        Cliente cliente = new Cliente(idCliente);

        if (qtd <= 2) {
            for (Mesa m : listaMesas2) {
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
            for (Mesa m : listaMesas4) {
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
            for (Mesa m : listaMesas10) {
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

    public MesaResponse liberaMesa(Mesa m, Long qntMesa) {
        MesaResponse response = new MesaResponse();

        if (qntMesa == 2) {
            listaMesas2.get(m.getId()).setPreenchida(false);
            listaMesas2.get(m.getId()).setCliente(null);
        } else if (qntMesa == 4) {
            listaMesas2.get(m.getId()).setPreenchida(false);
            listaMesas2.get(m.getId()).setCliente(null);
        } else if (qntMesa == 10) {
            listaMesas2.get(m.getId()).setPreenchida(false);
            listaMesas2.get(m.getId()).setCliente(null);
        }
        response.setMensagem("Mesa " + m.getId() + " liberada com sucesso");
        response.setSucesso(true);
        return response;
    }

    public MesaResponse verificaDisponibilidade(Long qtd, Long idCliente) {

        if (qtd <= 2) {


        } else if (qtd <= 4) {


        } else if (qtd <= 10) {


        }
        return null;
    }
}
