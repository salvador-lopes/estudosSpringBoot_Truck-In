package com.backend.truckin.controllers;




import com.backend.truckin.controllers.forms.SessaoTrabalhoForm;
import com.backend.truckin.mappers.SessaoTrabalhoMapper;
import com.backend.truckin.models.*;
import com.backend.truckin.repositories.SessaoRepository;
import com.backend.truckin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SessaoTrabalhoController
{
    @Autowired
    private SessaoRepository sessaoRepository;

    IdManager classe = new IdManager();

    @RequestMapping("sessaoTrabalho")
    public String sessaoTrabalho()
    {
        System.out.println("Chegou" + classe.Id_Trabalho);
        return ("sessaoTrabalho");
    }
    @RequestMapping(value = "salvarHorario", method = RequestMethod.POST)
    public String salvarHorario(@Valid SessaoTrabalhoForm updateTrab, Model model)
    {
        long id = classe.Id_Trabalho;
        long status = 1;
        SessaoTrabalhoMapper mapper = new SessaoTrabalhoMapper();
        SessaoTrabalho sessaoTrabalhoUpdate = sessaoRepository.findById(id);
        SessaoTrabalho sessaoTrabalho = mapper.map(sessaoTrabalhoUpdate, updateTrab );
        updateTrab.setId(id);
        sessaoTrabalho.setStatus(status);
        sessaoTrabalho.setNomeCliente(sessaoTrabalhoUpdate.getNomeCliente());


        sessaoRepository.save(sessaoTrabalho);
        System.out.println(updateTrab);

        return "sessaoTrabalho";
    }


}