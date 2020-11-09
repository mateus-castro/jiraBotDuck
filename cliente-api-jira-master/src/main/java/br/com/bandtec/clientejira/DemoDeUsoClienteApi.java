package br.com.bandtec.clientejira;

import br.com.bandtec.clientejira.modelo.Issue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class DemoDeUsoClienteApi {

    public static void main(String[] args) throws IOException {

        // Este "gson" Ã© opcional. Apenas para imprimir os objetos na saÃ­da padrÃ£o, caso queira.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ClienteJiraApi clienteJiraApi = new ClienteJiraApi(
                "pneu-duck.atlassian.net",
                "jennifer.silva@bandtec.com.br",
                "5By0fA4ynKitjeXjfuhFAC91"
        );

//        Issue issue = clienteJiraApi.getIssue("BDJ");
//        System.out.println("Issue recuperada: "+gson.toJson(issue));

        // Exemplo de objeto para novo chamado (Issue)
        Issue novaIssue = new Issue();
        novaIssue.setProjectKey("BDJ");
        novaIssue.setSummary("Uso crítico de CPU e Disco");
        novaIssue.setDescription("CPU em 99% \nDisco em 89% \nMemória em 45.6%");
        novaIssue.setLabels("alerta-cpu", "alerta-disco");

        clienteJiraApi.criarIssue(novaIssue);
        System.out.println("Issue criada: "+gson.toJson(novaIssue));

    }
}
