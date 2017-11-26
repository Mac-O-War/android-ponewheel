package net.kwatts.powtools.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Nullable;
import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Ride.class,
        parentColumns = "id",
        childColumns = "ride_id",
        onDelete = CASCADE))
public class Moment {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "ride_id")
    public long rideId;

    @Nullable private Double gpsLat;
    @Nullable private Double gpsLong;

    private Date date;

    /**
     * @deprecated Not for public use, use @link(net.kwatts.powtools.database.Moment#Moment(long, java.util.Date))
     */
    public Moment() {}

    @Ignore
    public Moment(long rideId, Date date) {
        this.rideId = rideId;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public void setGpsLat(double gpsLat) {
        this.gpsLat = gpsLat;
    }
    public Double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLong(double gpsLong) {
        this.gpsLong = gpsLong;
    }
    public Double getGpsLong() {
        return gpsLong;
    }
}
