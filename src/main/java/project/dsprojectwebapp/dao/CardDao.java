package project.dsprojectwebapp.dao;

import org.springframework.stereotype.Repository;
import project.dsprojectwebapp.model.Card;

import java.util.List;
import java.util.Optional;

public interface CardDao{

    Optional<Card> retrieveCardByTag(String tag);

    String retrieveImagePathByTag(String tag);
}
