package sample.service;

import sample.entity.Tweet;

public class TweetService extends AbstractService<Tweet> {

    public Tweet findById(Integer id) {
        return select().id(id).getSingleResult();
    }

}
