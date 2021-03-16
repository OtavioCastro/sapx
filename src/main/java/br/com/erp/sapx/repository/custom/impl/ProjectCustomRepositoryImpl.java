package br.com.erp.sapx.repository.custom.impl;

import br.com.erp.sapx.repository.custom.ProjectCustomRepository;
import br.com.erp.sapx.repository.model.ProjectModel;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import java.util.List;

@AllArgsConstructor
public class ProjectCustomRepositoryImpl implements ProjectCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<ProjectModel> findProjectsWithParams(Long numProj, String nomeCliente, String status) {

        Query mongoQuery = new Query();

        if(numProj > 0){
            mongoQuery.addCriteria(Criteria.where("numProjeto").is(numProj));
        }

        if(!StringUtils.isEmpty(nomeCliente)){
            mongoQuery.addCriteria(Criteria.where("cliente.nome").is(nomeCliente));
        }

        if(!StringUtils.isEmpty(status)){
            mongoQuery.addCriteria(Criteria.where("status").is(status));
        }

        return mongoTemplate.find(mongoQuery, ProjectModel.class);

    }

}
