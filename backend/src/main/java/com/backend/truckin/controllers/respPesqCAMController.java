package com.backend.truckin.controllers;
import com.backend.truckin.models.IdManager;
import com.backend.truckin.models.LOG;
import com.backend.truckin.models.Veiculo;
import com.backend.truckin.repositories.LOGRepository;
import com.backend.truckin.repositories.UserRepository;
import com.backend.truckin.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class respPesqCAMController
{
    @Autowired
    VeiculoRepository veiculoRepository;
    @Autowired
    LOGRepository logRepository;

    IdManager classe = new IdManager();
    @RequestMapping("respPesqCAM")
    public String respPlaca(Model model){
        LOG logSessaoDeTrabalho = new LOG();
        logSessaoDeTrabalho.setAcaoEfetuada("Pesquisou veículo pela placa - " + classe.NomePesqPlaca);
        logSessaoDeTrabalho.setIdAdm(classe.Id_Adm);
        logSessaoDeTrabalho.setIdUser(classe.Id_PerfilUsu);
        logRepository.save(logSessaoDeTrabalho);
        long PerfilId = classe.Id_PerfilUsu;
        System.out.println(classe.Id_Adm +" Este usuário verficiou os dados do caminhão com a placa " + classe.NomePesqUsu);
        Iterable<Veiculo> respPlaca = veiculoRepository.findAllByPlaca(classe.NomePesqPlaca);
        model.addAttribute("respPesqCAM", respPlaca);
        return "respPesqCAM";
    }
}
