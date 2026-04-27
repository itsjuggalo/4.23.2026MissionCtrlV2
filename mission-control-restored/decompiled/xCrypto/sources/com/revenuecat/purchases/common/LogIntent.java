package com.revenuecat.purchases.common;

import X2.AbstractC0768o;
import X2.AbstractC0769p;
import com.revenuecat.purchases.strings.Emojis;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public enum LogIntent {
    DEBUG(AbstractC0768o.b(Emojis.INFO)),
    GOOGLE_ERROR(AbstractC0769p.j(Emojis.ROBOT, Emojis.DOUBLE_EXCLAMATION)),
    GOOGLE_WARNING(AbstractC0769p.j(Emojis.ROBOT, Emojis.DOUBLE_EXCLAMATION)),
    INFO(AbstractC0768o.b(Emojis.INFO)),
    PURCHASE(AbstractC0768o.b(Emojis.MONEY_BAG)),
    RC_ERROR(AbstractC0769p.j(Emojis.SAD_CAT_EYES, Emojis.DOUBLE_EXCLAMATION)),
    RC_PURCHASE_SUCCESS(AbstractC0769p.j(Emojis.HEART_CAT_EYES, Emojis.MONEY_BAG)),
    RC_SUCCESS(AbstractC0768o.b(Emojis.HEART_CAT_EYES)),
    USER(AbstractC0768o.b(Emojis.PERSON)),
    WARNING(AbstractC0768o.b(Emojis.WARNING)),
    AMAZON_WARNING(AbstractC0769p.j(Emojis.BOX, Emojis.DOUBLE_EXCLAMATION)),
    AMAZON_ERROR(AbstractC0769p.j(Emojis.BOX, Emojis.DOUBLE_EXCLAMATION));

    private final List<String> emojiList;

    LogIntent(List list) {
        this.emojiList = list;
    }

    public final List<String> getEmojiList() {
        return this.emojiList;
    }
}
