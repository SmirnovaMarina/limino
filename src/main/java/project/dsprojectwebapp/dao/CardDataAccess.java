package project.dsprojectwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project.dsprojectwebapp.model.Card;

import java.util.*;

@Repository
public class CardDataAccess implements CardDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CardDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Card> retrieveCardByTag(String tag) {

        String query = "SELECT id, description, imagePath, tags, POSITION(? IN tags) FROM card WHERE POSITION(? IN tags) != 0";

        List<Card> cards = jdbcTemplate.query(query, new Object[]{tag, tag}, (resultSet, i) -> {
            UUID cardId = UUID.fromString(resultSet.getString("id"));
            String description = resultSet.getString("description");
            String path = resultSet.getString("imagePath");
            String tags[] = resultSet.getString("tags").split(",");

            return new Card(cardId, description, path, Arrays.asList(tags));
        });

        Random rand = new Random();
        return Optional.ofNullable(cards.get(rand.nextInt(cards.size())));
    }

    @Override
    public String retrieveImagePathByTag(String tag) {
        String query = "SELECT id, description, imagePath, tags, POSITION(? IN tags) FROM card WHERE POSITION(? IN tags) != 0";

        List<Card> cards = jdbcTemplate.query(query, new Object[]{tag, tag}, (resultSet, i) -> {
            UUID cardId = UUID.fromString(resultSet.getString("id"));
            String description = resultSet.getString("description");
            String path = resultSet.getString("imagePath");
            String tags[] = resultSet.getString("tags").split(",");

            return new Card(cardId, description, path, Arrays.asList(tags));
        });

        Random rand = new Random();

        if (cards != null && cards.size() > 0) {
            return cards.get(rand.nextInt(cards.size())).getImagePath();
        }
        else {
            return Card.DEFAULT_IMAGE_PATH;
        }
    }
}
