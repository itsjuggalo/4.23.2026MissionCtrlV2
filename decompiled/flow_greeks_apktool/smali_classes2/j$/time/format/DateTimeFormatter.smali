.class public final Lj$/time/format/DateTimeFormatter;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final ISO_LOCAL_DATE:Lj$/time/format/DateTimeFormatter;

.field public static final ISO_LOCAL_DATE_TIME:Lj$/time/format/DateTimeFormatter;

.field public static final f:Lj$/time/format/DateTimeFormatter;


# instance fields
.field public final a:Lj$/time/format/d;

.field public final b:Ljava/util/Locale;

.field public final c:Lj$/time/format/v;

.field public final d:Lj$/time/format/x;

.field public final e:Lj$/time/chrono/l;


# direct methods
.method static constructor <clinit>()V
    .locals 21

    .line 740
    new-instance v0, Lj$/time/format/o;

    invoke-direct {v0}, Lj$/time/format/o;-><init>()V

    sget-object v1, Lj$/time/temporal/a;->YEAR:Lj$/time/temporal/a;

    sget-object v2, Lj$/time/format/y;->EXCEEDS_PAD:Lj$/time/format/y;

    const/4 v3, 0x4

    const/16 v4, 0xa

    .line 741
    invoke-virtual {v0, v1, v3, v4, v2}, Lj$/time/format/o;->h(Lj$/time/temporal/q;IILj$/time/format/y;)V

    const/16 v5, 0x2d

    .line 742
    invoke-virtual {v0, v5}, Lj$/time/format/o;->c(C)V

    sget-object v6, Lj$/time/temporal/a;->MONTH_OF_YEAR:Lj$/time/temporal/a;

    const/4 v7, 0x2

    .line 743
    invoke-virtual {v0, v6, v7}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 744
    invoke-virtual {v0, v5}, Lj$/time/format/o;->c(C)V

    sget-object v8, Lj$/time/temporal/a;->DAY_OF_MONTH:Lj$/time/temporal/a;

    .line 745
    invoke-virtual {v0, v8, v7}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    sget-object v9, Lj$/time/format/x;->STRICT:Lj$/time/format/x;

    sget-object v10, Lj$/time/chrono/s;->c:Lj$/time/chrono/s;

    .line 746
    invoke-virtual {v0, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    move-result-object v0

    sput-object v0, Lj$/time/format/DateTimeFormatter;->ISO_LOCAL_DATE:Lj$/time/format/DateTimeFormatter;

    .line 770
    new-instance v11, Lj$/time/format/o;

    invoke-direct {v11}, Lj$/time/format/o;-><init>()V

    .line 313
    sget-object v12, Lj$/time/format/l;->INSENSITIVE:Lj$/time/format/l;

    invoke-virtual {v11, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 772
    invoke-virtual {v11, v0}, Lj$/time/format/o;->a(Lj$/time/format/DateTimeFormatter;)V

    .line 916
    sget-object v13, Lj$/time/format/i;->e:Lj$/time/format/i;

    invoke-virtual {v11, v13}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 774
    invoke-virtual {v11, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    .line 802
    new-instance v11, Lj$/time/format/o;

    invoke-direct {v11}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v11, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 804
    invoke-virtual {v11, v0}, Lj$/time/format/o;->a(Lj$/time/format/DateTimeFormatter;)V

    .line 805
    invoke-virtual {v11}, Lj$/time/format/o;->j()V

    .line 916
    invoke-virtual {v11, v13}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 807
    invoke-virtual {v11, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    .line 839
    new-instance v11, Lj$/time/format/o;

    invoke-direct {v11}, Lj$/time/format/o;-><init>()V

    sget-object v14, Lj$/time/temporal/a;->HOUR_OF_DAY:Lj$/time/temporal/a;

    .line 840
    invoke-virtual {v11, v14, v7}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    const/16 v15, 0x3a

    .line 841
    invoke-virtual {v11, v15}, Lj$/time/format/o;->c(C)V

    sget-object v5, Lj$/time/temporal/a;->MINUTE_OF_HOUR:Lj$/time/temporal/a;

    .line 842
    invoke-virtual {v11, v5, v7}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 843
    invoke-virtual {v11}, Lj$/time/format/o;->j()V

    .line 844
    invoke-virtual {v11, v15}, Lj$/time/format/o;->c(C)V

    sget-object v15, Lj$/time/temporal/a;->SECOND_OF_MINUTE:Lj$/time/temporal/a;

    .line 845
    invoke-virtual {v11, v15, v7}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 846
    invoke-virtual {v11}, Lj$/time/format/o;->j()V

    sget-object v7, Lj$/time/temporal/a;->NANO_OF_SECOND:Lj$/time/temporal/a;

    .line 717
    new-instance v3, Lj$/time/format/f;

    invoke-direct {v3, v7}, Lj$/time/format/f;-><init>(Lj$/time/temporal/q;)V

    invoke-virtual {v11, v3}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    const/4 v3, 0x0

    .line 848
    invoke-virtual {v11, v9, v3}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    move-result-object v7

    .line 871
    new-instance v11, Lj$/time/format/o;

    invoke-direct {v11}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v11, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 873
    invoke-virtual {v11, v7}, Lj$/time/format/o;->a(Lj$/time/format/DateTimeFormatter;)V

    .line 916
    invoke-virtual {v11, v13}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 875
    invoke-virtual {v11, v9, v3}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    .line 902
    new-instance v11, Lj$/time/format/o;

    invoke-direct {v11}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v11, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 904
    invoke-virtual {v11, v7}, Lj$/time/format/o;->a(Lj$/time/format/DateTimeFormatter;)V

    .line 905
    invoke-virtual {v11}, Lj$/time/format/o;->j()V

    .line 916
    invoke-virtual {v11, v13}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 907
    invoke-virtual {v11, v9, v3}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    .line 930
    new-instance v11, Lj$/time/format/o;

    invoke-direct {v11}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v11, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 932
    invoke-virtual {v11, v0}, Lj$/time/format/o;->a(Lj$/time/format/DateTimeFormatter;)V

    const/16 v0, 0x54

    .line 933
    invoke-virtual {v11, v0}, Lj$/time/format/o;->c(C)V

    .line 934
    invoke-virtual {v11, v7}, Lj$/time/format/o;->a(Lj$/time/format/DateTimeFormatter;)V

    .line 935
    invoke-virtual {v11, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    move-result-object v0

    sput-object v0, Lj$/time/format/DateTimeFormatter;->ISO_LOCAL_DATE_TIME:Lj$/time/format/DateTimeFormatter;

    .line 960
    new-instance v7, Lj$/time/format/o;

    invoke-direct {v7}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v7, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 962
    invoke-virtual {v7, v0}, Lj$/time/format/o;->a(Lj$/time/format/DateTimeFormatter;)V

    .line 351
    sget-object v11, Lj$/time/format/l;->LENIENT:Lj$/time/format/l;

    invoke-virtual {v7, v11}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 916
    invoke-virtual {v7, v13}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 332
    sget-object v3, Lj$/time/format/l;->STRICT:Lj$/time/format/l;

    invoke-virtual {v7, v3}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 966
    invoke-virtual {v7, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    move-result-object v7

    .line 994
    new-instance v4, Lj$/time/format/o;

    invoke-direct {v4}, Lj$/time/format/o;-><init>()V

    .line 995
    invoke-virtual {v4, v7}, Lj$/time/format/o;->a(Lj$/time/format/DateTimeFormatter;)V

    .line 996
    invoke-virtual {v4}, Lj$/time/format/o;->j()V

    const/16 v7, 0x5b

    .line 997
    invoke-virtual {v4, v7}, Lj$/time/format/o;->c(C)V

    .line 293
    sget-object v7, Lj$/time/format/l;->SENSITIVE:Lj$/time/format/l;

    invoke-virtual {v4, v7}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    move-object/from16 v19, v15

    .line 1136
    new-instance v15, Lj$/time/format/g;

    move-object/from16 v20, v5

    const/4 v5, 0x1

    .line 4201
    invoke-direct {v15, v5}, Lj$/time/format/g;-><init>(I)V

    .line 1136
    invoke-virtual {v4, v15}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    const/16 v5, 0x5d

    .line 1000
    invoke-virtual {v4, v5}, Lj$/time/format/o;->c(C)V

    .line 1001
    invoke-virtual {v4, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    .line 1035
    new-instance v4, Lj$/time/format/o;

    invoke-direct {v4}, Lj$/time/format/o;-><init>()V

    .line 1036
    invoke-virtual {v4, v0}, Lj$/time/format/o;->a(Lj$/time/format/DateTimeFormatter;)V

    .line 1037
    invoke-virtual {v4}, Lj$/time/format/o;->j()V

    .line 916
    invoke-virtual {v4, v13}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 1039
    invoke-virtual {v4}, Lj$/time/format/o;->j()V

    const/16 v0, 0x5b

    .line 1040
    invoke-virtual {v4, v0}, Lj$/time/format/o;->c(C)V

    .line 293
    invoke-virtual {v4, v7}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 1136
    new-instance v0, Lj$/time/format/g;

    const/4 v7, 0x1

    .line 4201
    invoke-direct {v0, v7}, Lj$/time/format/g;-><init>(I)V

    .line 1136
    invoke-virtual {v4, v0}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 1043
    invoke-virtual {v4, v5}, Lj$/time/format/o;->c(C)V

    .line 1044
    invoke-virtual {v4, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    .line 1077
    new-instance v0, Lj$/time/format/o;

    invoke-direct {v0}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v0, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    const/4 v4, 0x4

    const/16 v5, 0xa

    .line 1079
    invoke-virtual {v0, v1, v4, v5, v2}, Lj$/time/format/o;->h(Lj$/time/temporal/q;IILj$/time/format/y;)V

    const/16 v4, 0x2d

    .line 1080
    invoke-virtual {v0, v4}, Lj$/time/format/o;->c(C)V

    sget-object v4, Lj$/time/temporal/a;->DAY_OF_YEAR:Lj$/time/temporal/a;

    const/4 v5, 0x3

    .line 1081
    invoke-virtual {v0, v4, v5}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 1082
    invoke-virtual {v0}, Lj$/time/format/o;->j()V

    .line 916
    invoke-virtual {v0, v13}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 1084
    invoke-virtual {v0, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    .line 1121
    new-instance v0, Lj$/time/format/o;

    invoke-direct {v0}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v0, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 1122
    sget-object v4, Lj$/time/temporal/j;->c:Lj$/time/temporal/h;

    const/4 v5, 0x4

    const/16 v7, 0xa

    .line 1123
    invoke-virtual {v0, v4, v5, v7, v2}, Lj$/time/format/o;->h(Lj$/time/temporal/q;IILj$/time/format/y;)V

    const-string v2, "-W"

    .line 1124
    invoke-virtual {v0, v2}, Lj$/time/format/o;->d(Ljava/lang/String;)V

    sget-object v2, Lj$/time/temporal/j;->b:Lj$/time/temporal/h;

    const/4 v4, 0x2

    .line 1125
    invoke-virtual {v0, v2, v4}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    const/16 v4, 0x2d

    .line 1126
    invoke-virtual {v0, v4}, Lj$/time/format/o;->c(C)V

    sget-object v2, Lj$/time/temporal/a;->DAY_OF_WEEK:Lj$/time/temporal/a;

    const/4 v4, 0x1

    .line 1127
    invoke-virtual {v0, v2, v4}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 1128
    invoke-virtual {v0}, Lj$/time/format/o;->j()V

    .line 916
    invoke-virtual {v0, v13}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 1130
    invoke-virtual {v0, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    .line 1166
    new-instance v0, Lj$/time/format/o;

    invoke-direct {v0}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v0, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 856
    new-instance v5, Lj$/time/format/g;

    const/4 v7, 0x0

    .line 3407
    invoke-direct {v5, v7}, Lj$/time/format/g;-><init>(I)V

    .line 856
    invoke-virtual {v0, v5}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    const/4 v5, 0x0

    .line 1169
    invoke-virtual {v0, v9, v5}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    move-result-object v0

    sput-object v0, Lj$/time/format/DateTimeFormatter;->f:Lj$/time/format/DateTimeFormatter;

    .line 1203
    new-instance v0, Lj$/time/format/o;

    invoke-direct {v0}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v0, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    const/4 v5, 0x4

    .line 1205
    invoke-virtual {v0, v1, v5}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    const/4 v5, 0x2

    .line 1206
    invoke-virtual {v0, v6, v5}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 1207
    invoke-virtual {v0, v8, v5}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 1208
    invoke-virtual {v0}, Lj$/time/format/o;->j()V

    .line 351
    invoke-virtual {v0, v11}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 990
    new-instance v5, Lj$/time/format/i;

    const-string v7, "+HHMMss"

    const-string v13, "Z"

    invoke-direct {v5, v7, v13}, Lj$/time/format/i;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 332
    invoke-virtual {v0, v3}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 1212
    invoke-virtual {v0, v9, v10}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    .line 1263
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-wide/16 v15, 0x1

    .line 1264
    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    const-string v5, "Mon"

    invoke-virtual {v0, v3, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v15, 0x2

    .line 1265
    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    const-string v7, "Tue"

    invoke-virtual {v0, v5, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v15, 0x3

    .line 1266
    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    const-string v9, "Wed"

    invoke-virtual {v0, v7, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v15, 0x4

    .line 1267
    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    const-string v13, "Thu"

    invoke-virtual {v0, v9, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v15, 0x5

    .line 1268
    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    const-string v15, "Fri"

    invoke-virtual {v0, v13, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v15, 0x6

    .line 1269
    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    const-string v4, "Sat"

    invoke-virtual {v0, v15, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v17, 0x7

    .line 1270
    invoke-static/range {v17 .. v18}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v17, v10

    const-string v10, "Sun"

    invoke-virtual {v0, v4, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1271
    new-instance v10, Ljava/util/HashMap;

    invoke-direct {v10}, Ljava/util/HashMap;-><init>()V

    move-object/from16 v18, v14

    .line 1272
    const-string v14, "Jan"

    invoke-virtual {v10, v3, v14}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1273
    const-string v3, "Feb"

    invoke-virtual {v10, v5, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1274
    const-string v3, "Mar"

    invoke-virtual {v10, v7, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1275
    const-string v3, "Apr"

    invoke-virtual {v10, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1276
    const-string v3, "May"

    invoke-virtual {v10, v13, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1277
    const-string v3, "Jun"

    invoke-virtual {v10, v15, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1278
    const-string v3, "Jul"

    invoke-virtual {v10, v4, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v3, 0x8

    .line 1279
    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    const-string v4, "Aug"

    invoke-virtual {v10, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v3, 0x9

    .line 1280
    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    const-string v4, "Sep"

    invoke-virtual {v10, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v3, 0xa

    .line 1281
    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    const-string v4, "Oct"

    invoke-virtual {v10, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v3, 0xb

    .line 1282
    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    const-string v4, "Nov"

    invoke-virtual {v10, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-wide/16 v3, 0xc

    .line 1283
    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    const-string v4, "Dec"

    invoke-virtual {v10, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1284
    new-instance v3, Lj$/time/format/o;

    invoke-direct {v3}, Lj$/time/format/o;-><init>()V

    .line 313
    invoke-virtual {v3, v12}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 351
    invoke-virtual {v3, v11}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 1287
    invoke-virtual {v3}, Lj$/time/format/o;->j()V

    .line 1288
    invoke-virtual {v3, v2, v0}, Lj$/time/format/o;->e(Lj$/time/temporal/a;Ljava/util/Map;)V

    const-string v0, ", "

    .line 1289
    invoke-virtual {v3, v0}, Lj$/time/format/o;->d(Ljava/lang/String;)V

    .line 1290
    invoke-virtual {v3}, Lj$/time/format/o;->i()V

    sget-object v0, Lj$/time/format/y;->NOT_NEGATIVE:Lj$/time/format/y;

    const/4 v2, 0x1

    const/4 v4, 0x2

    .line 1291
    invoke-virtual {v3, v8, v2, v4, v0}, Lj$/time/format/o;->h(Lj$/time/temporal/q;IILj$/time/format/y;)V

    const/16 v0, 0x20

    .line 1292
    invoke-virtual {v3, v0}, Lj$/time/format/o;->c(C)V

    .line 1293
    invoke-virtual {v3, v6, v10}, Lj$/time/format/o;->e(Lj$/time/temporal/a;Ljava/util/Map;)V

    .line 1294
    invoke-virtual {v3, v0}, Lj$/time/format/o;->c(C)V

    const/4 v5, 0x4

    .line 1295
    invoke-virtual {v3, v1, v5}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 1296
    invoke-virtual {v3, v0}, Lj$/time/format/o;->c(C)V

    move-object/from16 v1, v18

    .line 1297
    invoke-virtual {v3, v1, v4}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    const/16 v1, 0x3a

    .line 1298
    invoke-virtual {v3, v1}, Lj$/time/format/o;->c(C)V

    move-object/from16 v2, v20

    .line 1299
    invoke-virtual {v3, v2, v4}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 1300
    invoke-virtual {v3}, Lj$/time/format/o;->j()V

    .line 1301
    invoke-virtual {v3, v1}, Lj$/time/format/o;->c(C)V

    move-object/from16 v1, v19

    .line 1302
    invoke-virtual {v3, v1, v4}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 1303
    invoke-virtual {v3}, Lj$/time/format/o;->i()V

    .line 1304
    invoke-virtual {v3, v0}, Lj$/time/format/o;->c(C)V

    .line 990
    new-instance v0, Lj$/time/format/i;

    const-string v1, "+HHMM"

    const-string v2, "GMT"

    invoke-direct {v0, v1, v2}, Lj$/time/format/i;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Lj$/time/format/o;->b(Lj$/time/format/e;)I

    .line 1305
    sget-object v0, Lj$/time/format/x;->SMART:Lj$/time/format/x;

    move-object/from16 v1, v17

    .line 1306
    invoke-virtual {v3, v0, v1}, Lj$/time/format/o;->k(Lj$/time/format/x;Lj$/time/chrono/l;)Lj$/time/format/DateTimeFormatter;

    return-void
.end method

.method public constructor <init>(Lj$/time/format/d;Ljava/util/Locale;Lj$/time/format/x;Lj$/time/chrono/l;)V
    .locals 1

    sget-object v0, Lj$/time/format/v;->a:Lj$/time/format/v;

    .line 1417
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1418
    iput-object p1, p0, Lj$/time/format/DateTimeFormatter;->a:Lj$/time/format/d;

    .line 1420
    const-string p1, "locale"

    invoke-static {p2, p1}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iput-object p2, p0, Lj$/time/format/DateTimeFormatter;->b:Ljava/util/Locale;

    .line 1421
    iput-object v0, p0, Lj$/time/format/DateTimeFormatter;->c:Lj$/time/format/v;

    .line 1422
    const-string p1, "resolverStyle"

    invoke-static {p3, p1}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iput-object p3, p0, Lj$/time/format/DateTimeFormatter;->d:Lj$/time/format/x;

    .line 1423
    iput-object p4, p0, Lj$/time/format/DateTimeFormatter;->e:Lj$/time/chrono/l;

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/CharSequence;)Lj$/time/format/w;
    .locals 26

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    .line 1988
    new-instance v2, Ljava/text/ParsePosition;

    const/4 v3, 0x0

    invoke-direct {v2, v3}, Ljava/text/ParsePosition;-><init>(I)V

    .line 2058
    new-instance v4, Lj$/time/format/p;

    invoke-direct {v4, v0}, Lj$/time/format/p;-><init>(Lj$/time/format/DateTimeFormatter;)V

    .line 2059
    invoke-virtual {v2}, Ljava/text/ParsePosition;->getIndex()I

    move-result v5

    .line 2060
    iget-object v6, v0, Lj$/time/format/DateTimeFormatter;->a:Lj$/time/format/d;

    invoke-virtual {v6, v4, v1, v5}, Lj$/time/format/d;->A(Lj$/time/format/p;Ljava/lang/CharSequence;I)I

    move-result v5

    const/4 v6, 0x0

    if-gez v5, :cond_0

    not-int v4, v5

    .line 2062
    invoke-virtual {v2, v4}, Ljava/text/ParsePosition;->setErrorIndex(I)V

    move-object v4, v6

    goto :goto_0

    .line 2065
    :cond_0
    invoke-virtual {v2, v5}, Ljava/text/ParsePosition;->setIndex(I)V

    :goto_0
    if-eqz v4, :cond_24

    .line 1990
    iget-object v5, v4, Lj$/time/format/p;->a:Lj$/time/format/DateTimeFormatter;

    invoke-virtual {v2}, Ljava/text/ParsePosition;->getErrorIndex()I

    move-result v7

    if-gez v7, :cond_24

    invoke-virtual {v2}, Ljava/text/ParsePosition;->getIndex()I

    move-result v7

    invoke-interface {v1}, Ljava/lang/CharSequence;->length()I

    move-result v8

    if-ge v7, v8, :cond_1

    goto/16 :goto_12

    .line 328
    :cond_1
    invoke-virtual {v4}, Lj$/time/format/p;->c()Lj$/time/format/w;

    move-result-object v9

    .line 167
    invoke-virtual {v4}, Lj$/time/format/p;->c()Lj$/time/format/w;

    move-result-object v1

    iget-object v1, v1, Lj$/time/format/w;->c:Lj$/time/chrono/l;

    if-nez v1, :cond_2

    .line 1501
    iget-object v1, v5, Lj$/time/format/DateTimeFormatter;->e:Lj$/time/chrono/l;

    if-nez v1, :cond_2

    .line 171
    sget-object v1, Lj$/time/chrono/s;->c:Lj$/time/chrono/s;

    .line 329
    :cond_2
    iput-object v1, v9, Lj$/time/format/w;->c:Lj$/time/chrono/l;

    .line 330
    iget-object v1, v9, Lj$/time/format/w;->b:Lj$/time/ZoneId;

    if-eqz v1, :cond_3

    move-object v6, v1

    goto :goto_1

    .line 1555
    :cond_3
    invoke-virtual {v5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 330
    :goto_1
    iput-object v6, v9, Lj$/time/format/w;->b:Lj$/time/ZoneId;

    .line 252
    iget-object v1, v0, Lj$/time/format/DateTimeFormatter;->d:Lj$/time/format/x;

    iput-object v1, v9, Lj$/time/format/w;->e:Lj$/time/format/x;

    .line 265
    invoke-virtual {v9}, Lj$/time/format/w;->q()V

    .line 360
    iget-object v1, v9, Lj$/time/format/w;->c:Lj$/time/chrono/l;

    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    iget-object v4, v9, Lj$/time/format/w;->e:Lj$/time/format/x;

    invoke-interface {v1, v2, v4}, Lj$/time/chrono/l;->S(Ljava/util/Map;Lj$/time/format/x;)Lj$/time/chrono/b;

    move-result-object v1

    invoke-virtual {v9, v1}, Lj$/time/format/w;->y(Lj$/time/chrono/b;)V

    .line 267
    invoke-virtual {v9}, Lj$/time/format/w;->u()V

    .line 271
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->size()I

    move-result v1

    if-lez v1, :cond_e

    :goto_2
    const/16 v1, 0x32

    if-ge v3, v1, :cond_c

    .line 275
    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v2, Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_4
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_c

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 276
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lj$/time/temporal/q;

    .line 277
    iget-object v5, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    iget-object v6, v9, Lj$/time/format/w;->e:Lj$/time/format/x;

    invoke-interface {v4, v5, v9, v6}, Lj$/time/temporal/q;->F(Ljava/util/Map;Lj$/time/format/w;Lj$/time/format/x;)Lj$/time/temporal/TemporalAccessor;

    move-result-object v5

    if-eqz v5, :cond_b

    .line 279
    instance-of v1, v5, Lj$/time/chrono/ChronoZonedDateTime;

    if-eqz v1, :cond_7

    .line 280
    check-cast v5, Lj$/time/chrono/ChronoZonedDateTime;

    .line 281
    iget-object v1, v9, Lj$/time/format/w;->b:Lj$/time/ZoneId;

    if-nez v1, :cond_5

    .line 282
    invoke-interface {v5}, Lj$/time/chrono/ChronoZonedDateTime;->J()Lj$/time/ZoneId;

    move-result-object v1

    iput-object v1, v9, Lj$/time/format/w;->b:Lj$/time/ZoneId;

    goto :goto_3

    .line 283
    :cond_5
    invoke-interface {v5}, Lj$/time/chrono/ChronoZonedDateTime;->J()Lj$/time/ZoneId;

    move-result-object v2

    invoke-virtual {v1, v2}, Lj$/time/ZoneId;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 286
    :goto_3
    invoke-interface {v5}, Lj$/time/chrono/ChronoZonedDateTime;->x()Lj$/time/chrono/e;

    move-result-object v5

    goto :goto_4

    .line 284
    :cond_6
    new-instance v1, Lj$/time/c;

    iget-object v2, v9, Lj$/time/format/w;->b:Lj$/time/ZoneId;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "ChronoZonedDateTime must use the effective parsed zone: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 88
    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 284
    throw v1

    .line 288
    :cond_7
    :goto_4
    instance-of v1, v5, Lj$/time/chrono/e;

    if-eqz v1, :cond_8

    .line 289
    check-cast v5, Lj$/time/chrono/e;

    .line 290
    invoke-interface {v5}, Lj$/time/chrono/e;->j()Lj$/time/l;

    move-result-object v1

    sget-object v2, Lj$/time/s;->d:Lj$/time/s;

    invoke-virtual {v9, v1, v2}, Lj$/time/format/w;->v(Lj$/time/l;Lj$/time/s;)V

    .line 291
    invoke-interface {v5}, Lj$/time/chrono/e;->n()Lj$/time/chrono/b;

    move-result-object v1

    invoke-virtual {v9, v1}, Lj$/time/format/w;->y(Lj$/time/chrono/b;)V

    :goto_5
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 295
    :cond_8
    instance-of v1, v5, Lj$/time/chrono/b;

    if-eqz v1, :cond_9

    .line 296
    check-cast v5, Lj$/time/chrono/b;

    invoke-virtual {v9, v5}, Lj$/time/format/w;->y(Lj$/time/chrono/b;)V

    goto :goto_5

    .line 300
    :cond_9
    instance-of v1, v5, Lj$/time/l;

    if-eqz v1, :cond_a

    .line 301
    check-cast v5, Lj$/time/l;

    sget-object v1, Lj$/time/s;->d:Lj$/time/s;

    invoke-virtual {v9, v5, v1}, Lj$/time/format/w;->v(Lj$/time/l;Lj$/time/s;)V

    goto :goto_5

    .line 305
    :cond_a
    new-instance v1, Lj$/time/c;

    const-string v2, "Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime"

    .line 88
    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 305
    throw v1

    .line 307
    :cond_b
    iget-object v5, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v5, Ljava/util/HashMap;

    invoke-virtual {v5, v4}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4

    goto :goto_5

    :cond_c
    if-eq v3, v1, :cond_d

    if-lez v3, :cond_e

    .line 319
    invoke-virtual {v9}, Lj$/time/format/w;->q()V

    .line 360
    iget-object v1, v9, Lj$/time/format/w;->c:Lj$/time/chrono/l;

    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    iget-object v3, v9, Lj$/time/format/w;->e:Lj$/time/format/x;

    invoke-interface {v1, v2, v3}, Lj$/time/chrono/l;->S(Ljava/util/Map;Lj$/time/format/x;)Lj$/time/chrono/b;

    move-result-object v1

    invoke-virtual {v9, v1}, Lj$/time/format/w;->y(Lj$/time/chrono/b;)V

    .line 321
    invoke-virtual {v9}, Lj$/time/format/w;->u()V

    goto :goto_6

    .line 315
    :cond_d
    new-instance v1, Lj$/time/c;

    const-string v2, "One of the parsed fields has an incorrectly implemented resolve method"

    .line 88
    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 315
    throw v1

    .line 489
    :cond_e
    :goto_6
    iget-object v1, v9, Lj$/time/format/w;->g:Lj$/time/l;

    const-wide/32 v2, 0xf4240

    const-wide/16 v4, 0x3e8

    const-wide/16 v6, 0x0

    if-nez v1, :cond_18

    .line 491
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v8, Lj$/time/temporal/a;->MILLI_OF_SECOND:Lj$/time/temporal/a;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v8}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 492
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v8}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    .line 493
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v12, Lj$/time/temporal/a;->MICRO_OF_SECOND:Lj$/time/temporal/a;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v12}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_f

    mul-long/2addr v10, v4

    .line 495
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v12}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v13

    rem-long/2addr v13, v4

    add-long/2addr v13, v10

    .line 496
    invoke-static {v13, v14}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v9, v8, v12, v1}, Lj$/time/format/w;->z(Lj$/time/temporal/q;Lj$/time/temporal/a;Ljava/lang/Long;)V

    .line 497
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v12}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 498
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v8, Lj$/time/temporal/a;->NANO_OF_SECOND:Lj$/time/temporal/a;

    mul-long/2addr v13, v4

    invoke-static {v13, v14}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v8, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_7

    .line 501
    :cond_f
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v8, Lj$/time/temporal/a;->NANO_OF_SECOND:Lj$/time/temporal/a;

    mul-long/2addr v10, v2

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v8, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_7

    .line 503
    :cond_10
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v8, Lj$/time/temporal/a;->MICRO_OF_SECOND:Lj$/time/temporal/a;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v8}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 505
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v8}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    .line 506
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v8, Lj$/time/temporal/a;->NANO_OF_SECOND:Lj$/time/temporal/a;

    mul-long/2addr v10, v4

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v8, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 510
    :cond_11
    :goto_7
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v8, Lj$/time/temporal/a;->HOUR_OF_DAY:Lj$/time/temporal/a;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    if-eqz v1, :cond_18

    .line 512
    iget-object v10, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v11, Lj$/time/temporal/a;->MINUTE_OF_HOUR:Lj$/time/temporal/a;

    check-cast v10, Ljava/util/HashMap;

    invoke-virtual {v10, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/Long;

    .line 513
    iget-object v12, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v13, Lj$/time/temporal/a;->SECOND_OF_MINUTE:Lj$/time/temporal/a;

    check-cast v12, Ljava/util/HashMap;

    invoke-virtual {v12, v13}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/Long;

    .line 514
    iget-object v14, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v15, Lj$/time/temporal/a;->NANO_OF_SECOND:Lj$/time/temporal/a;

    check-cast v14, Ljava/util/HashMap;

    invoke-virtual {v14, v15}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/Long;

    if-nez v10, :cond_13

    if-nez v12, :cond_12

    if-nez v14, :cond_12

    goto :goto_9

    :cond_12
    :goto_8
    move-wide/from16 v18, v2

    goto/16 :goto_f

    :cond_13
    :goto_9
    if-eqz v10, :cond_14

    if-nez v12, :cond_14

    if-eqz v14, :cond_14

    goto :goto_8

    :cond_14
    if-eqz v10, :cond_15

    .line 523
    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v16

    goto :goto_a

    :cond_15
    move-wide/from16 v16, v6

    :goto_a
    if-eqz v12, :cond_16

    .line 524
    invoke-virtual {v12}, Ljava/lang/Long;->longValue()J

    move-result-wide v18

    goto :goto_b

    :cond_16
    move-wide/from16 v18, v6

    :goto_b
    if-eqz v14, :cond_17

    .line 525
    invoke-virtual {v14}, Ljava/lang/Long;->longValue()J

    move-result-wide v20

    goto :goto_c

    :cond_17
    move-wide/from16 v20, v6

    .line 526
    :goto_c
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v22

    move-wide/from16 v24, v2

    move-object v3, v15

    move-wide/from16 v14, v18

    move-wide/from16 v18, v24

    move-object v1, v11

    move-object v2, v13

    move-wide/from16 v12, v16

    move-wide/from16 v16, v20

    move-wide/from16 v10, v22

    invoke-virtual/range {v9 .. v17}, Lj$/time/format/w;->s(JJJJ)V

    .line 527
    iget-object v10, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v10, Ljava/util/HashMap;

    invoke-virtual {v10, v8}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 528
    iget-object v8, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v8, Ljava/util/HashMap;

    invoke-virtual {v8, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 529
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 530
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_d

    :cond_18
    move-wide/from16 v18, v2

    .line 535
    :goto_d
    iget-object v1, v9, Lj$/time/format/w;->e:Lj$/time/format/x;

    sget-object v2, Lj$/time/format/x;->LENIENT:Lj$/time/format/x;

    if-eq v1, v2, :cond_1a

    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->size()I

    move-result v1

    if-lez v1, :cond_1a

    .line 536
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_19
    :goto_e
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1a

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 537
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lj$/time/temporal/q;

    .line 538
    instance-of v8, v3, Lj$/time/temporal/a;

    if-eqz v8, :cond_19

    check-cast v3, Lj$/time/temporal/a;

    invoke-virtual {v3}, Lj$/time/temporal/a;->Y()Z

    move-result v8

    if-eqz v8, :cond_19

    .line 539
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    invoke-virtual {v3, v10, v11}, Lj$/time/temporal/a;->X(J)V

    goto :goto_e

    .line 633
    :cond_1a
    :goto_f
    iget-object v1, v9, Lj$/time/format/w;->f:Lj$/time/chrono/b;

    if-eqz v1, :cond_1b

    .line 634
    invoke-virtual {v9, v1}, Lj$/time/format/w;->p(Lj$/time/temporal/TemporalAccessor;)V

    .line 636
    :cond_1b
    iget-object v1, v9, Lj$/time/format/w;->g:Lj$/time/l;

    if-eqz v1, :cond_1c

    .line 637
    invoke-virtual {v9, v1}, Lj$/time/format/w;->p(Lj$/time/temporal/TemporalAccessor;)V

    .line 638
    iget-object v1, v9, Lj$/time/format/w;->f:Lj$/time/chrono/b;

    if-eqz v1, :cond_1c

    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->size()I

    move-result v1

    if-lez v1, :cond_1c

    .line 639
    iget-object v1, v9, Lj$/time/format/w;->f:Lj$/time/chrono/b;

    iget-object v2, v9, Lj$/time/format/w;->g:Lj$/time/l;

    invoke-interface {v1, v2}, Lj$/time/chrono/b;->L(Lj$/time/l;)Lj$/time/chrono/e;

    move-result-object v1

    invoke-virtual {v9, v1}, Lj$/time/format/w;->p(Lj$/time/temporal/TemporalAccessor;)V

    .line 570
    :cond_1c
    iget-object v1, v9, Lj$/time/format/w;->f:Lj$/time/chrono/b;

    if-eqz v1, :cond_1e

    iget-object v1, v9, Lj$/time/format/w;->g:Lj$/time/l;

    if-eqz v1, :cond_1e

    iget-object v1, v9, Lj$/time/format/w;->h:Lj$/time/s;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 490
    sget-object v2, Lj$/time/s;->d:Lj$/time/s;

    if-ne v1, v2, :cond_1d

    goto :goto_10

    .line 571
    :cond_1d
    iget-object v1, v9, Lj$/time/format/w;->f:Lj$/time/chrono/b;

    iget-object v3, v9, Lj$/time/format/w;->h:Lj$/time/s;

    invoke-interface {v1, v3}, Lj$/time/chrono/b;->R(Lj$/time/temporal/p;)Lj$/time/chrono/b;

    move-result-object v1

    iput-object v1, v9, Lj$/time/format/w;->f:Lj$/time/chrono/b;

    .line 572
    iput-object v2, v9, Lj$/time/format/w;->h:Lj$/time/s;

    .line 588
    :cond_1e
    :goto_10
    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 579
    iget-object v2, v9, Lj$/time/format/w;->g:Lj$/time/l;

    if-nez v2, :cond_21

    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v3, Lj$/time/temporal/a;->INSTANT_SECONDS:Lj$/time/temporal/a;

    .line 580
    check-cast v2, Ljava/util/HashMap;

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1f

    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v3, Lj$/time/temporal/a;->SECOND_OF_DAY:Lj$/time/temporal/a;

    .line 581
    check-cast v2, Ljava/util/HashMap;

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1f

    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v3, Lj$/time/temporal/a;->SECOND_OF_MINUTE:Lj$/time/temporal/a;

    .line 582
    check-cast v2, Ljava/util/HashMap;

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_21

    .line 583
    :cond_1f
    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v3, Lj$/time/temporal/a;->NANO_OF_SECOND:Lj$/time/temporal/a;

    check-cast v2, Ljava/util/HashMap;

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_20

    .line 584
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    .line 585
    iget-object v3, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v6, Lj$/time/temporal/a;->MICRO_OF_SECOND:Lj$/time/temporal/a;

    div-long v4, v1, v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    check-cast v3, Ljava/util/HashMap;

    invoke-virtual {v3, v6, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 586
    iget-object v3, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v4, Lj$/time/temporal/a;->MILLI_OF_SECOND:Lj$/time/temporal/a;

    div-long v1, v1, v18

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    check-cast v3, Ljava/util/HashMap;

    invoke-virtual {v3, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_11

    .line 588
    :cond_20
    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    check-cast v2, Ljava/util/HashMap;

    invoke-virtual {v2, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 589
    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v3, Lj$/time/temporal/a;->MICRO_OF_SECOND:Lj$/time/temporal/a;

    check-cast v2, Ljava/util/HashMap;

    invoke-virtual {v2, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 590
    iget-object v2, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v3, Lj$/time/temporal/a;->MILLI_OF_SECOND:Lj$/time/temporal/a;

    check-cast v2, Ljava/util/HashMap;

    invoke-virtual {v2, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 598
    :cond_21
    :goto_11
    iget-object v1, v9, Lj$/time/format/w;->f:Lj$/time/chrono/b;

    if-eqz v1, :cond_23

    iget-object v1, v9, Lj$/time/format/w;->g:Lj$/time/l;

    if-eqz v1, :cond_23

    .line 599
    iget-object v1, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v2, Lj$/time/temporal/a;->OFFSET_SECONDS:Lj$/time/temporal/a;

    check-cast v1, Ljava/util/HashMap;

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    if-eqz v1, :cond_22

    .line 601
    invoke-virtual {v1}, Ljava/lang/Long;->intValue()I

    move-result v1

    invoke-static {v1}, Lj$/time/ZoneOffset;->Y(I)Lj$/time/ZoneOffset;

    move-result-object v1

    .line 602
    iget-object v2, v9, Lj$/time/format/w;->f:Lj$/time/chrono/b;

    iget-object v3, v9, Lj$/time/format/w;->g:Lj$/time/l;

    invoke-interface {v2, v3}, Lj$/time/chrono/b;->L(Lj$/time/l;)Lj$/time/chrono/e;

    move-result-object v2

    invoke-interface {v2, v1}, Lj$/time/chrono/e;->E(Lj$/time/ZoneId;)Lj$/time/chrono/ChronoZonedDateTime;

    move-result-object v1

    invoke-interface {v1}, Lj$/time/chrono/ChronoZonedDateTime;->W()J

    move-result-wide v1

    .line 603
    iget-object v3, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v4, Lj$/time/temporal/a;->INSTANT_SECONDS:Lj$/time/temporal/a;

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    check-cast v3, Ljava/util/HashMap;

    invoke-virtual {v3, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-object v9

    .line 605
    :cond_22
    iget-object v1, v9, Lj$/time/format/w;->b:Lj$/time/ZoneId;

    if-eqz v1, :cond_23

    .line 606
    iget-object v1, v9, Lj$/time/format/w;->f:Lj$/time/chrono/b;

    iget-object v2, v9, Lj$/time/format/w;->g:Lj$/time/l;

    invoke-interface {v1, v2}, Lj$/time/chrono/b;->L(Lj$/time/l;)Lj$/time/chrono/e;

    move-result-object v1

    iget-object v2, v9, Lj$/time/format/w;->b:Lj$/time/ZoneId;

    invoke-interface {v1, v2}, Lj$/time/chrono/e;->E(Lj$/time/ZoneId;)Lj$/time/chrono/ChronoZonedDateTime;

    move-result-object v1

    invoke-interface {v1}, Lj$/time/chrono/ChronoZonedDateTime;->W()J

    move-result-wide v1

    .line 607
    iget-object v3, v9, Lj$/time/format/w;->a:Ljava/util/Map;

    sget-object v4, Lj$/time/temporal/a;->INSTANT_SECONDS:Lj$/time/temporal/a;

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    check-cast v3, Ljava/util/HashMap;

    invoke-virtual {v3, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_23
    return-object v9

    .line 1992
    :cond_24
    :goto_12
    invoke-interface {v1}, Ljava/lang/CharSequence;->length()I

    move-result v4

    const/16 v5, 0x40

    if-le v4, v5, :cond_25

    .line 1993
    invoke-interface {v1, v3, v5}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "..."

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_13

    .line 1995
    :cond_25
    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1997
    :goto_13
    invoke-virtual {v2}, Ljava/text/ParsePosition;->getErrorIndex()I

    move-result v4

    const-string v5, "Text \'"

    if-ltz v4, :cond_26

    .line 1998
    new-instance v4, Lj$/time/format/q;

    .line 1999
    invoke-virtual {v2}, Ljava/text/ParsePosition;->getErrorIndex()I

    move-result v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "\' could not be parsed at index "

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2}, Ljava/text/ParsePosition;->getErrorIndex()I

    invoke-direct {v4, v3, v1}, Lj$/time/format/q;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;)V

    throw v4

    .line 2001
    :cond_26
    new-instance v4, Lj$/time/format/q;

    .line 2002
    invoke-virtual {v2}, Ljava/text/ParsePosition;->getIndex()I

    move-result v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "\' could not be parsed, unparsed text found at index "

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2}, Ljava/text/ParsePosition;->getIndex()I

    invoke-direct {v4, v3, v1}, Lj$/time/format/q;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;)V

    throw v4
.end method

.method public format(Lj$/time/temporal/TemporalAccessor;)Ljava/lang/String;
    .locals 3

    .line 1769
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x20

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1791
    iget-object v1, p0, Lj$/time/format/DateTimeFormatter;->a:Lj$/time/format/d;

    const-string v2, "temporal"

    invoke-static {p1, v2}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 1794
    :try_start_0
    new-instance v2, Lj$/time/format/s;

    invoke-direct {v2, p1, p0}, Lj$/time/format/s;-><init>(Lj$/time/temporal/TemporalAccessor;Lj$/time/format/DateTimeFormatter;)V

    .line 1796
    invoke-virtual {v1, v2, v0}, Lj$/time/format/d;->s(Lj$/time/format/s;Ljava/lang/StringBuilder;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1771
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :catch_0
    move-exception p1

    .line 1804
    new-instance v0, Lj$/time/c;

    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v1

    .line 98
    invoke-direct {v0, v1, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1804
    throw v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 3

    .line 2126
    iget-object v0, p0, Lj$/time/format/DateTimeFormatter;->a:Lj$/time/format/d;

    invoke-virtual {v0}, Lj$/time/format/d;->toString()Ljava/lang/String;

    move-result-object v0

    .line 2127
    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    return-object v0

    :cond_0
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    invoke-virtual {v0, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
