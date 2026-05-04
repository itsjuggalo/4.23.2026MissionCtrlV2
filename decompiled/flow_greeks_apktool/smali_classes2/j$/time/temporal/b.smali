.class public final enum Lj$/time/temporal/b;
.super Ljava/lang/Enum;
.source "SourceFile"

# interfaces
.implements Lj$/time/temporal/s;


# static fields
.field public static final enum CENTURIES:Lj$/time/temporal/b;

.field public static final enum DAYS:Lj$/time/temporal/b;

.field public static final enum DECADES:Lj$/time/temporal/b;

.field public static final enum ERAS:Lj$/time/temporal/b;

.field public static final enum FOREVER:Lj$/time/temporal/b;

.field public static final enum HALF_DAYS:Lj$/time/temporal/b;

.field public static final enum HOURS:Lj$/time/temporal/b;

.field public static final enum MICROS:Lj$/time/temporal/b;

.field public static final enum MILLENNIA:Lj$/time/temporal/b;

.field public static final enum MILLIS:Lj$/time/temporal/b;

.field public static final enum MINUTES:Lj$/time/temporal/b;

.field public static final enum MONTHS:Lj$/time/temporal/b;

.field public static final enum NANOS:Lj$/time/temporal/b;

.field public static final enum SECONDS:Lj$/time/temporal/b;

.field public static final enum WEEKS:Lj$/time/temporal/b;

.field public static final enum YEARS:Lj$/time/temporal/b;

.field public static final synthetic b:[Lj$/time/temporal/b;


# instance fields
.field public final a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 24

    .line 83
    new-instance v1, Lj$/time/temporal/b;

    const-wide/16 v2, 0x1

    invoke-static {v2, v3}, Lj$/time/e;->F(J)Lj$/time/e;

    const-string v0, "NANOS"

    const/4 v4, 0x0

    const-string v5, "Nanos"

    invoke-direct {v1, v0, v4, v5}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lj$/time/temporal/b;->NANOS:Lj$/time/temporal/b;

    .line 88
    new-instance v0, Lj$/time/temporal/b;

    const-wide/16 v5, 0x3e8

    invoke-static {v5, v6}, Lj$/time/e;->F(J)Lj$/time/e;

    const-string v5, "MICROS"

    const/4 v6, 0x1

    const-string v7, "Micros"

    invoke-direct {v0, v5, v6, v7}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lj$/time/temporal/b;->MICROS:Lj$/time/temporal/b;

    .line 93
    new-instance v5, Lj$/time/temporal/b;

    const-wide/32 v6, 0xf4240

    invoke-static {v6, v7}, Lj$/time/e;->F(J)Lj$/time/e;

    const-string v6, "MILLIS"

    const/4 v7, 0x2

    const-string v8, "Millis"

    invoke-direct {v5, v6, v7, v8}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lj$/time/temporal/b;->MILLIS:Lj$/time/temporal/b;

    .line 99
    new-instance v6, Lj$/time/temporal/b;

    .line 224
    invoke-static {v2, v3, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 99
    const-string v2, "SECONDS"

    const/4 v3, 0x3

    const-string v7, "Seconds"

    invoke-direct {v6, v2, v3, v7}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v6, Lj$/time/temporal/b;->SECONDS:Lj$/time/temporal/b;

    move-object v3, v5

    .line 104
    new-instance v5, Lj$/time/temporal/b;

    const-wide/16 v7, 0x3c

    .line 224
    invoke-static {v7, v8, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 104
    const-string v2, "MINUTES"

    const/4 v7, 0x4

    const-string v8, "Minutes"

    invoke-direct {v5, v2, v7, v8}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lj$/time/temporal/b;->MINUTES:Lj$/time/temporal/b;

    move-object v2, v6

    .line 109
    new-instance v6, Lj$/time/temporal/b;

    const-wide/16 v7, 0xe10

    .line 224
    invoke-static {v7, v8, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 109
    const-string v7, "HOURS"

    const/4 v8, 0x5

    const-string v9, "Hours"

    invoke-direct {v6, v7, v8, v9}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v6, Lj$/time/temporal/b;->HOURS:Lj$/time/temporal/b;

    .line 114
    new-instance v7, Lj$/time/temporal/b;

    const-wide/32 v8, 0xa8c0

    .line 224
    invoke-static {v8, v9, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 114
    const-string v8, "HALF_DAYS"

    const/4 v9, 0x6

    const-string v10, "HalfDays"

    invoke-direct {v7, v8, v9, v10}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v7, Lj$/time/temporal/b;->HALF_DAYS:Lj$/time/temporal/b;

    .line 125
    new-instance v8, Lj$/time/temporal/b;

    const-wide/32 v9, 0x15180

    .line 224
    invoke-static {v9, v10, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 125
    const-string v9, "DAYS"

    const/4 v10, 0x7

    const-string v11, "Days"

    invoke-direct {v8, v9, v10, v11}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v8, Lj$/time/temporal/b;->DAYS:Lj$/time/temporal/b;

    .line 132
    new-instance v9, Lj$/time/temporal/b;

    const-wide/32 v10, 0x93a80

    .line 224
    invoke-static {v10, v11, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 132
    const-string v10, "WEEKS"

    const/16 v11, 0x8

    const-string v12, "Weeks"

    invoke-direct {v9, v10, v11, v12}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v9, Lj$/time/temporal/b;->WEEKS:Lj$/time/temporal/b;

    .line 140
    new-instance v10, Lj$/time/temporal/b;

    const-wide/32 v11, 0x282072

    .line 224
    invoke-static {v11, v12, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 140
    const-string v11, "MONTHS"

    const/16 v12, 0x9

    const-string v13, "Months"

    invoke-direct {v10, v11, v12, v13}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v10, Lj$/time/temporal/b;->MONTHS:Lj$/time/temporal/b;

    .line 149
    new-instance v11, Lj$/time/temporal/b;

    const-wide/32 v12, 0x1e18558

    .line 224
    invoke-static {v12, v13, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 149
    const-string v12, "YEARS"

    const/16 v13, 0xa

    const-string v14, "Years"

    invoke-direct {v11, v12, v13, v14}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v11, Lj$/time/temporal/b;->YEARS:Lj$/time/temporal/b;

    .line 157
    new-instance v12, Lj$/time/temporal/b;

    const-wide/32 v13, 0x12cf3570

    .line 224
    invoke-static {v13, v14, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 157
    const-string v13, "DECADES"

    const/16 v14, 0xb

    const-string v15, "Decades"

    invoke-direct {v12, v13, v14, v15}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v12, Lj$/time/temporal/b;->DECADES:Lj$/time/temporal/b;

    .line 165
    new-instance v13, Lj$/time/temporal/b;

    const-wide v14, 0xbc181660L

    .line 224
    invoke-static {v14, v15, v4}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 165
    const-string v14, "CENTURIES"

    const/16 v15, 0xc

    const-string v4, "Centuries"

    invoke-direct {v13, v14, v15, v4}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v13, Lj$/time/temporal/b;->CENTURIES:Lj$/time/temporal/b;

    .line 173
    new-instance v14, Lj$/time/temporal/b;

    move-object v15, v0

    move-object v4, v1

    const-wide v0, 0x758f0dfc0L

    move-object/from16 v17, v2

    const/4 v2, 0x0

    .line 224
    invoke-static {v0, v1, v2}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 173
    const-string v0, "MILLENNIA"

    const/16 v1, 0xd

    const-string v2, "Millennia"

    invoke-direct {v14, v0, v1, v2}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v14, Lj$/time/temporal/b;->MILLENNIA:Lj$/time/temporal/b;

    move-object v2, v15

    .line 182
    new-instance v15, Lj$/time/temporal/b;

    const-wide v0, 0x701ce172277000L

    move-object/from16 v18, v2

    const/4 v2, 0x0

    .line 224
    invoke-static {v0, v1, v2}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 182
    const-string v0, "ERAS"

    const/16 v1, 0xe

    const-string v2, "Eras"

    invoke-direct {v15, v0, v1, v2}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v15, Lj$/time/temporal/b;->ERAS:Lj$/time/temporal/b;

    .line 190
    new-instance v0, Lj$/time/temporal/b;

    const-wide/32 v1, 0x3b9ac9ff

    move-object/from16 v16, v3

    move-object/from16 v19, v4

    const-wide/32 v3, 0x3b9aca00

    move-object/from16 v20, v5

    move-object/from16 v21, v6

    .line 247
    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->floorDiv(JJ)J

    move-result-wide v5

    move-object/from16 v22, v7

    move-object/from16 v23, v8

    const-wide v7, 0x7fffffffffffffffL

    invoke-static {v7, v8, v5, v6}, Ljava/lang/Math;->addExact(JJ)J

    move-result-wide v5

    .line 248
    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->floorMod(JJ)J

    move-result-wide v1

    long-to-int v1, v1

    .line 249
    invoke-static {v5, v6, v1}, Lj$/time/e;->A(JI)Lj$/time/e;

    .line 190
    const-string v1, "FOREVER"

    const/16 v2, 0xf

    const-string v3, "Forever"

    invoke-direct {v0, v1, v2, v3}, Lj$/time/temporal/b;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lj$/time/temporal/b;->FOREVER:Lj$/time/temporal/b;

    move-object/from16 v3, v16

    move-object/from16 v4, v17

    move-object/from16 v2, v18

    move-object/from16 v1, v19

    move-object/from16 v5, v20

    move-object/from16 v6, v21

    move-object/from16 v7, v22

    move-object/from16 v8, v23

    move-object/from16 v16, v0

    .line 77
    filled-new-array/range {v1 .. v16}, [Lj$/time/temporal/b;

    move-result-object v0

    sput-object v0, Lj$/time/temporal/b;->b:[Lj$/time/temporal/b;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0

    .line 195
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 196
    iput-object p3, p0, Lj$/time/temporal/b;->a:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lj$/time/temporal/b;
    .locals 1

    .line 77
    const-class v0, Lj$/time/temporal/b;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lj$/time/temporal/b;

    return-object p0
.end method

.method public static values()[Lj$/time/temporal/b;
    .locals 1

    .line 77
    sget-object v0, Lj$/time/temporal/b;->b:[Lj$/time/temporal/b;

    invoke-virtual {v0}, [Lj$/time/temporal/b;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lj$/time/temporal/b;

    return-object v0
.end method


# virtual methods
.method public final s(Lj$/time/temporal/m;J)Lj$/time/temporal/m;
    .locals 0

    .line 266
    invoke-interface {p1, p2, p3, p0}, Lj$/time/temporal/m;->d(JLj$/time/temporal/s;)Lj$/time/temporal/m;

    move-result-object p1

    return-object p1
.end method

.method public final toString()Ljava/lang/String;
    .locals 1

    .line 278
    iget-object v0, p0, Lj$/time/temporal/b;->a:Ljava/lang/String;

    return-object v0
.end method
