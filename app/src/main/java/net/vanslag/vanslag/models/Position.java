package net.vanslag.vanslag.models;

/**
 * Created by JVH on 26/08/16.
 */
public class Position {
    long id;

    long seasonId;
    long roundId;
    long pouleId;
    long teamId;

    int pos;
    int startPos;
    int points;

    int gamesWon;
    int gamesLost;
    int setsWon;
    int setsLost;

    String specialReason;
}
