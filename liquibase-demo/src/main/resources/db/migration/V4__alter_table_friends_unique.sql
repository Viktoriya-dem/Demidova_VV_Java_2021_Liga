ALTER TABLE friends
    ADD CHECK (friends.user_id != friends.user2_id);