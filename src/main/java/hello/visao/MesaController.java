package hello.visao;


import hello.Response.MesaResponse;
import modelo.Mesa;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import servicos.ServicoGerenciadorMesa;

@RestController
public class MesaController {

    private ServicoGerenciadorMesa servicoGerenciadorMesa = new ServicoGerenciadorMesa();

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping("/alocaMesa")
    public MesaResponse alocaMesa(@RequestParam(value="qtd") Long qtd,@RequestParam(value="idCliente")Long idCliente) {
        return this.servicoGerenciadorMesa.alocaMesa(qtd, idCliente);
    }

    @RequestMapping("/verificaDisponibilidade")
    public MesaResponse verificaDisponibilidade(@RequestParam(value="qtd") Long qtd,@RequestParam(value="idCliente")Long idCliente) {
        return this.servicoGerenciadorMesa.verificaDisponibilidade(qtd,idCliente);
    }

    @RequestMapping("/liberaMesa")
    public MesaResponse liberaMesa(Mesa m, @RequestParam(value="idCliente")Long idCliente) {
        return this.servicoGerenciadorMesa.liberaMesa(m,idCliente);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping("/teste")
    public String  teste() {
        return "Retorno ok";
    }


}
