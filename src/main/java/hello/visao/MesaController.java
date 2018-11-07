package hello.visao;


import hello.Response.MesaResponse;
import modelo.Mesa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import servicos.ServicoGerenciadorMesa;

@RestController
public class MesaController {

    private ServicoGerenciadorMesa servicoGerenciadorMesa = new ServicoGerenciadorMesa();

    @RequestMapping("/alocaMesa")
    public MesaResponse alocaMesa(@RequestParam(value="qtd") Long qtd,@RequestParam(value="idCliente")Long idCliente) {
        return this.servicoGerenciadorMesa.alocaMesa(qtd, idCliente);
    }

    @RequestMapping("/verificaDisponibilidade")
    public MesaResponse verificaDisponibilidade(@RequestParam(value="qtd") Long qtd,@RequestParam(value="idCliente")Long idCliente) {
        return this.servicoGerenciadorMesa.verificaDisponibilidade();
    }

    @RequestMapping("/liberaMesa")
    public MesaResponse liberaMesa(Mesa m, @RequestParam(value="idCliente")Long idCliente) {
        return this.servicoGerenciadorMesa.liberaMesa(m,idCliente);
    }

}
