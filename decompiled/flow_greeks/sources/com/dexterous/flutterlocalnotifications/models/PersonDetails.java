package com.dexterous.flutterlocalnotifications.models;

import androidx.annotation.Keep;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class PersonDetails implements Serializable {
    public Boolean bot;
    public Object icon;
    public IconSource iconBitmapSource;
    public Boolean important;
    public String key;
    public String name;
    public String uri;

    public PersonDetails(Boolean bool, Object obj, IconSource iconSource, Boolean bool2, String str, String str2, String str3) {
        this.bot = bool;
        this.icon = obj;
        this.iconBitmapSource = iconSource;
        this.important = bool2;
        this.key = str;
        this.name = str2;
        this.uri = str3;
    }
}
