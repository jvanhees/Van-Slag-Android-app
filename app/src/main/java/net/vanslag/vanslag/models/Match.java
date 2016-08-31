package net.vanslag.vanslag.models;

import java.util.Date;

/**
 * Created by JVH on 26/08/16.
 */
public class Match {
    long id;

    long team1Id;
    long team2Id;

    long locationId;
    long matchFieldId;
    long pouleId;
    long roundId;
    long refereeId;
    long seasonId;
    Date playedAt;
}
