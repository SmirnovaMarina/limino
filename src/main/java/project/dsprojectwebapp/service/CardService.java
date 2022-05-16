package project.dsprojectwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dsprojectwebapp.dao.CardDao;
import project.dsprojectwebapp.model.Card;
import java.util.Optional;

@Service
public class CardService {

    private final CardDao cardDao;

    @Autowired
    public CardService(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public Optional<Card> getCardByTag(String tag) {
        return cardDao.retrieveCardByTag(tag);
    }

    public String getImagePathByTag(String tag) {
        return cardDao.retrieveImagePathByTag(tag);
    }
}
