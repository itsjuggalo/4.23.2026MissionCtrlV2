.class public final Lj$/time/chrono/v;
.super Lj$/time/chrono/a;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final c:Lj$/time/chrono/v;

.field private static final serialVersionUID:J = 0x6623c4799cb0ddcL


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 132
    new-instance v0, Lj$/time/chrono/v;

    invoke-direct {v0}, Lj$/time/chrono/v;-><init>()V

    sput-object v0, Lj$/time/chrono/v;->c:Lj$/time/chrono/v;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 340
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private readObject(Ljava/io/ObjectInputStream;)V
    .locals 1

    .line 547
    new-instance p1, Ljava/io/InvalidObjectException;

    const-string v0, "Deserialization via serialization delegate"

    invoke-direct {p1, v0}, Ljava/io/InvalidObjectException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public final B(I)Lj$/time/chrono/m;
    .locals 0

    .line 382
    invoke-static {p1}, Lj$/time/chrono/y;->r(I)Lj$/time/chrono/y;

    move-result-object p1

    return-object p1
.end method

.method public final C(Lj$/time/chrono/m;I)I
    .locals 3

    .line 343
    instance-of v0, p1, Lj$/time/chrono/y;

    if-eqz v0, :cond_2

    .line 347
    move-object v0, p1

    check-cast v0, Lj$/time/chrono/y;

    .line 272
    iget-object v0, v0, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget v0, v0, Lj$/time/h;->a:I

    add-int v1, v0, p2

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    if-ne p2, v2, :cond_0

    goto :goto_0

    :cond_0
    const p2, -0x3b9ac9ff

    if-lt v1, p2, :cond_1

    const p2, 0x3b9ac9ff

    if-gt v1, p2, :cond_1

    if-lt v1, v0, :cond_1

    .line 362
    invoke-static {v1, v2, v2}, Lj$/time/h;->b0(III)Lj$/time/h;

    move-result-object p2

    invoke-static {p2}, Lj$/time/chrono/y;->p(Lj$/time/h;)Lj$/time/chrono/y;

    move-result-object p2

    if-ne p1, p2, :cond_1

    :goto_0
    return v1

    .line 366
    :cond_1
    new-instance p1, Lj$/time/c;

    const-string p2, "Invalid yearOfEra value"

    .line 88
    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 366
    throw p1

    .line 344
    :cond_2
    new-instance p1, Ljava/lang/ClassCastException;

    const-string p2, "Era must be JapaneseEra"

    invoke-direct {p1, p2}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public final G(Lj$/time/temporal/TemporalAccessor;)Lj$/time/chrono/b;
    .locals 1

    .line 301
    instance-of v0, p1, Lj$/time/chrono/x;

    if-eqz v0, :cond_0

    .line 302
    check-cast p1, Lj$/time/chrono/x;

    return-object p1

    .line 304
    :cond_0
    new-instance v0, Lj$/time/chrono/x;

    invoke-static {p1}, Lj$/time/h;->F(Lj$/time/temporal/TemporalAccessor;)Lj$/time/h;

    move-result-object p1

    invoke-direct {v0, p1}, Lj$/time/chrono/x;-><init>(Lj$/time/h;)V

    return-object v0
.end method

.method public final M()Lj$/time/chrono/b;
    .locals 2

    .line 286
    invoke-static {}, Lj$/time/b;->b()Lj$/time/a;

    move-result-object v0

    .line 296
    invoke-static {v0}, Lj$/time/h;->a0(Lj$/time/a;)Lj$/time/h;

    move-result-object v0

    .line 304
    new-instance v1, Lj$/time/chrono/x;

    invoke-static {v0}, Lj$/time/h;->F(Lj$/time/temporal/TemporalAccessor;)Lj$/time/h;

    move-result-object v0

    invoke-direct {v1, v0}, Lj$/time/chrono/x;-><init>(Lj$/time/h;)V

    return-object v1
.end method

.method public final Q(III)Lj$/time/chrono/b;
    .locals 1

    .line 224
    new-instance v0, Lj$/time/chrono/x;

    invoke-static {p1, p2, p3}, Lj$/time/h;->b0(III)Lj$/time/h;

    move-result-object p1

    invoke-direct {v0, p1}, Lj$/time/chrono/x;-><init>(Lj$/time/h;)V

    return-object v0
.end method

.method public final S(Ljava/util/Map;Lj$/time/format/x;)Lj$/time/chrono/b;
    .locals 0

    .line 438
    invoke-super {p0, p1, p2}, Lj$/time/chrono/a;->S(Ljava/util/Map;Lj$/time/format/x;)Lj$/time/chrono/b;

    move-result-object p1

    check-cast p1, Lj$/time/chrono/x;

    return-object p1
.end method

.method public final T(Lj$/time/Instant;Lj$/time/ZoneId;)Lj$/time/chrono/ChronoZonedDateTime;
    .locals 0

    .line 534
    invoke-static {p0, p1, p2}, Lj$/time/chrono/k;->F(Lj$/time/chrono/l;Lj$/time/Instant;Lj$/time/ZoneId;)Lj$/time/chrono/k;

    move-result-object p1

    return-object p1
.end method

.method public final V(Ljava/util/Map;Lj$/time/format/x;)Lj$/time/chrono/b;
    .locals 11

    .line 444
    sget-object v0, Lj$/time/temporal/a;->ERA:Lj$/time/temporal/a;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    .line 447
    invoke-virtual {p0, v0}, Lj$/time/chrono/v;->y(Lj$/time/temporal/a;)Lj$/time/temporal/u;

    move-result-object v3

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5, v0}, Lj$/time/temporal/u;->a(JLj$/time/temporal/q;)I

    move-result v1

    .line 382
    invoke-static {v1}, Lj$/time/chrono/y;->r(I)Lj$/time/chrono/y;

    move-result-object v1

    goto :goto_0

    :cond_0
    move-object v1, v2

    .line 449
    :goto_0
    sget-object v3, Lj$/time/temporal/a;->YEAR_OF_ERA:Lj$/time/temporal/a;

    invoke-interface {p1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Long;

    if-eqz v4, :cond_1

    .line 452
    invoke-virtual {p0, v3}, Lj$/time/chrono/v;->y(Lj$/time/temporal/a;)Lj$/time/temporal/u;

    move-result-object v5

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7, v3}, Lj$/time/temporal/u;->a(JLj$/time/temporal/q;)I

    move-result v5

    goto :goto_1

    :cond_1
    const/4 v5, 0x0

    :goto_1
    const/4 v6, 0x1

    if-nez v1, :cond_2

    if-eqz v4, :cond_2

    .line 455
    sget-object v7, Lj$/time/temporal/a;->YEAR:Lj$/time/temporal/a;

    invoke-interface {p1, v7}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_2

    sget-object v7, Lj$/time/format/x;->STRICT:Lj$/time/format/x;

    if-eq p2, v7, :cond_2

    .line 335
    sget-object v1, Lj$/time/chrono/y;->e:[Lj$/time/chrono/y;

    array-length v7, v1

    invoke-static {v1, v7}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Lj$/time/chrono/y;

    array-length v8, v1

    invoke-static {v1, v8}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lj$/time/chrono/y;

    .line 456
    array-length v1, v1

    sub-int/2addr v1, v6

    aget-object v1, v7, v1

    :cond_2
    if-eqz v4, :cond_d

    if-eqz v1, :cond_d

    .line 460
    sget-object v4, Lj$/time/temporal/a;->MONTH_OF_YEAR:Lj$/time/temporal/a;

    invoke-interface {p1, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    const-wide/16 v8, 0x1

    if-eqz v7, :cond_9

    .line 461
    sget-object v7, Lj$/time/temporal/a;->DAY_OF_MONTH:Lj$/time/temporal/a;

    invoke-interface {p1, v7}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_9

    .line 479
    invoke-interface {p1, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 480
    invoke-interface {p1, v3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 481
    sget-object v0, Lj$/time/format/x;->LENIENT:Lj$/time/format/x;

    if-ne p2, v0, :cond_3

    .line 272
    iget-object p2, v1, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget p2, p2, Lj$/time/h;->a:I

    add-int/2addr p2, v5

    sub-int/2addr p2, v6

    .line 483
    invoke-interface {p1, v4}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1, v8, v9}, Ljava/lang/Math;->subtractExact(JJ)J

    move-result-wide v0

    .line 484
    invoke-interface {p1, v7}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v2, v3, v8, v9}, Ljava/lang/Math;->subtractExact(JJ)J

    move-result-wide v2

    .line 224
    new-instance p1, Lj$/time/chrono/x;

    invoke-static {p2, v6, v6}, Lj$/time/h;->b0(III)Lj$/time/h;

    move-result-object p2

    invoke-direct {p1, p2}, Lj$/time/chrono/x;-><init>(Lj$/time/h;)V

    .line 485
    sget-object p2, Lj$/time/temporal/b;->MONTHS:Lj$/time/temporal/b;

    invoke-virtual {p1, v0, v1, p2}, Lj$/time/chrono/x;->P(JLj$/time/temporal/b;)Lj$/time/chrono/x;

    move-result-object p1

    sget-object p2, Lj$/time/temporal/b;->DAYS:Lj$/time/temporal/b;

    invoke-virtual {p1, v2, v3, p2}, Lj$/time/chrono/x;->P(JLj$/time/temporal/b;)Lj$/time/chrono/x;

    move-result-object p1

    return-object p1

    .line 487
    :cond_3
    invoke-virtual {p0, v4}, Lj$/time/chrono/v;->y(Lj$/time/temporal/a;)Lj$/time/temporal/u;

    move-result-object v0

    invoke-interface {p1, v4}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3, v4}, Lj$/time/temporal/u;->a(JLj$/time/temporal/q;)I

    move-result v0

    .line 488
    invoke-virtual {p0, v7}, Lj$/time/chrono/v;->y(Lj$/time/temporal/a;)Lj$/time/temporal/u;

    move-result-object v2

    invoke-interface {p1, v7}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4, v7}, Lj$/time/temporal/u;->a(JLj$/time/temporal/q;)I

    move-result p1

    .line 489
    sget-object v2, Lj$/time/format/x;->SMART:Lj$/time/format/x;

    if-ne p2, v2, :cond_7

    if-lt v5, v6, :cond_6

    .line 272
    iget-object p2, v1, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget p2, p2, Lj$/time/h;->a:I

    add-int/2addr p2, v5

    sub-int/2addr p2, v6

    .line 224
    :try_start_0
    new-instance v2, Lj$/time/chrono/x;

    invoke-static {p2, v0, p1}, Lj$/time/h;->b0(III)Lj$/time/h;

    move-result-object p1

    invoke-direct {v2, p1}, Lj$/time/chrono/x;-><init>(Lj$/time/h;)V
    :try_end_0
    .catch Lj$/time/c; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 224
    :catch_0
    new-instance p1, Lj$/time/chrono/x;

    invoke-static {p2, v0, v6}, Lj$/time/h;->b0(III)Lj$/time/h;

    move-result-object p2

    invoke-direct {p1, p2}, Lj$/time/chrono/x;-><init>(Lj$/time/h;)V

    .line 189
    new-instance p2, Lj$/time/i;

    const/4 v0, 0x2

    .line 0
    invoke-direct {p2, v0}, Lj$/time/i;-><init>(I)V

    .line 498
    invoke-virtual {p1, p2}, Lj$/time/chrono/x;->Y(Lj$/time/i;)Lj$/time/chrono/x;

    move-result-object v2

    .line 396
    :goto_2
    iget-object p1, v2, Lj$/time/chrono/x;->b:Lj$/time/chrono/y;

    if-eq p1, v1, :cond_5

    .line 503
    sget-object p1, Lj$/time/temporal/a;->YEAR_OF_ERA:Lj$/time/temporal/a;

    invoke-interface {v2, p1}, Lj$/time/temporal/TemporalAccessor;->g(Lj$/time/temporal/q;)I

    move-result p1

    if-le p1, v6, :cond_5

    if-gt v5, v6, :cond_4

    goto :goto_3

    .line 504
    :cond_4
    new-instance p1, Lj$/time/c;

    new-instance p2, Ljava/lang/StringBuilder;

    const-string v0, "Invalid YearOfEra for Era: "

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v0, " "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 88
    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 504
    throw p1

    :cond_5
    :goto_3
    return-object v2

    .line 491
    :cond_6
    new-instance p1, Lj$/time/c;

    new-instance p2, Ljava/lang/StringBuilder;

    const-string v0, "Invalid YearOfEra: "

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 88
    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 491
    throw p1

    .line 206
    :cond_7
    sget-object p2, Lj$/time/chrono/x;->d:Lj$/time/h;

    .line 272
    iget-object p2, v1, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget p2, p2, Lj$/time/h;->a:I

    add-int/2addr p2, v5

    sub-int/2addr p2, v6

    .line 233
    invoke-static {p2, v0, p1}, Lj$/time/h;->b0(III)Lj$/time/h;

    move-result-object p1

    .line 272
    iget-object p2, v1, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 234
    invoke-virtual {p1, p2}, Lj$/time/h;->X(Lj$/time/chrono/b;)Z

    move-result p2

    if-nez p2, :cond_8

    invoke-static {p1}, Lj$/time/chrono/y;->p(Lj$/time/h;)Lj$/time/chrono/y;

    move-result-object p2

    if-ne v1, p2, :cond_8

    .line 237
    new-instance p2, Lj$/time/chrono/x;

    invoke-direct {p2, v1, v5, p1}, Lj$/time/chrono/x;-><init>(Lj$/time/chrono/y;ILj$/time/h;)V

    return-object p2

    .line 235
    :cond_8
    new-instance p1, Lj$/time/c;

    const-string p2, "year, month, and day not valid for Era"

    .line 88
    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 235
    throw p1

    .line 465
    :cond_9
    sget-object v4, Lj$/time/temporal/a;->DAY_OF_YEAR:Lj$/time/temporal/a;

    invoke-interface {p1, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_d

    .line 512
    invoke-interface {p1, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 513
    invoke-interface {p1, v3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 514
    sget-object v0, Lj$/time/format/x;->LENIENT:Lj$/time/format/x;

    if-ne p2, v0, :cond_a

    .line 272
    iget-object p2, v1, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget p2, p2, Lj$/time/h;->a:I

    add-int/2addr p2, v5

    sub-int/2addr p2, v6

    .line 516
    invoke-interface {p1, v4}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1, v8, v9}, Ljava/lang/Math;->subtractExact(JJ)J

    move-result-wide v0

    .line 269
    new-instance p1, Lj$/time/chrono/x;

    invoke-static {p2, v6}, Lj$/time/h;->d0(II)Lj$/time/h;

    move-result-object p2

    invoke-direct {p1, p2}, Lj$/time/chrono/x;-><init>(Lj$/time/h;)V

    .line 517
    sget-object p2, Lj$/time/temporal/b;->DAYS:Lj$/time/temporal/b;

    invoke-virtual {p1, v0, v1, p2}, Lj$/time/chrono/x;->P(JLj$/time/temporal/b;)Lj$/time/chrono/x;

    move-result-object p1

    return-object p1

    .line 519
    :cond_a
    invoke-virtual {p0, v4}, Lj$/time/chrono/v;->y(Lj$/time/temporal/a;)Lj$/time/temporal/u;

    move-result-object p2

    invoke-interface {p1, v4}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {p2, v2, v3, v4}, Lj$/time/temporal/u;->a(JLj$/time/temporal/q;)I

    move-result p1

    .line 251
    sget-object p2, Lj$/time/chrono/x;->d:Lj$/time/h;

    if-ne v5, v6, :cond_b

    .line 272
    iget-object p2, v1, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget v0, p2, Lj$/time/h;->a:I

    .line 306
    invoke-virtual {p2}, Lj$/time/h;->V()I

    move-result p2

    add-int/2addr p2, p1

    sub-int/2addr p2, v6

    .line 305
    invoke-static {v0, p2}, Lj$/time/h;->d0(II)Lj$/time/h;

    move-result-object p1

    goto :goto_4

    .line 272
    :cond_b
    iget-object p2, v1, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget p2, p2, Lj$/time/h;->a:I

    add-int/2addr p2, v5

    sub-int/2addr p2, v6

    .line 308
    invoke-static {p2, p1}, Lj$/time/h;->d0(II)Lj$/time/h;

    move-result-object p1

    .line 272
    :goto_4
    iget-object p2, v1, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 310
    invoke-virtual {p1, p2}, Lj$/time/h;->X(Lj$/time/chrono/b;)Z

    move-result p2

    if-nez p2, :cond_c

    invoke-static {p1}, Lj$/time/chrono/y;->p(Lj$/time/h;)Lj$/time/chrono/y;

    move-result-object p2

    if-ne v1, p2, :cond_c

    .line 313
    new-instance p2, Lj$/time/chrono/x;

    invoke-direct {p2, v1, v5, p1}, Lj$/time/chrono/x;-><init>(Lj$/time/chrono/y;ILj$/time/h;)V

    return-object p2

    .line 311
    :cond_c
    new-instance p1, Lj$/time/c;

    const-string p2, "Invalid parameters"

    .line 88
    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 311
    throw p1

    :cond_d
    return-object v2
.end method

.method public final p(J)Lj$/time/chrono/b;
    .locals 1

    .line 281
    new-instance v0, Lj$/time/chrono/x;

    invoke-static {p1, p2}, Lj$/time/h;->c0(J)Lj$/time/h;

    move-result-object p1

    invoke-direct {v0, p1}, Lj$/time/chrono/x;-><init>(Lj$/time/h;)V

    return-object v0
.end method

.method public final q()Ljava/lang/String;
    .locals 1

    .line 158
    const-string v0, "Japanese"

    return-object v0
.end method

.method public final u()Ljava/lang/String;
    .locals 1

    .line 175
    const-string v0, "japanese"

    return-object v0
.end method

.method public final v(II)Lj$/time/chrono/b;
    .locals 1

    .line 269
    new-instance v0, Lj$/time/chrono/x;

    invoke-static {p1, p2}, Lj$/time/h;->d0(II)Lj$/time/h;

    move-result-object p1

    invoke-direct {v0, p1}, Lj$/time/chrono/x;-><init>(Lj$/time/h;)V

    return-object v0
.end method

.method public writeReplace()Ljava/lang/Object;
    .locals 2

    .line 747
    new-instance v0, Lj$/time/chrono/e0;

    const/4 v1, 0x1

    invoke-direct {v0, v1, p0}, Lj$/time/chrono/e0;-><init>(BLjava/lang/Object;)V

    return-object v0
.end method

.method public final y(Lj$/time/temporal/a;)Lj$/time/temporal/u;
    .locals 8

    .line 400
    sget-object v0, Lj$/time/chrono/u;->a:[I

    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x0

    const/4 v2, 0x1

    packed-switch v0, :pswitch_data_0

    .line 669
    iget-object p1, p1, Lj$/time/temporal/a;->b:Lj$/time/temporal/u;

    return-object p1

    .line 429
    :pswitch_0
    sget-object p1, Lj$/time/chrono/y;->d:Lj$/time/chrono/y;

    .line 422
    iget p1, p1, Lj$/time/chrono/y;->a:I

    int-to-long v0, p1

    .line 199
    sget-object p1, Lj$/time/chrono/y;->e:[Lj$/time/chrono/y;

    array-length v3, p1

    sub-int/2addr v3, v2

    aget-object p1, p1, v3

    .line 422
    iget p1, p1, Lj$/time/chrono/y;->a:I

    int-to-long v2, p1

    .line 429
    invoke-static {v0, v1, v2, v3}, Lj$/time/temporal/u;->f(JJ)Lj$/time/temporal/u;

    move-result-object p1

    return-object p1

    .line 425
    :pswitch_1
    sget-object p1, Lj$/time/chrono/x;->d:Lj$/time/h;

    .line 762
    iget p1, p1, Lj$/time/h;->a:I

    int-to-long v0, p1

    const-wide/32 v2, 0x3b9ac9ff

    .line 425
    invoke-static {v0, v1, v2, v3}, Lj$/time/temporal/u;->f(JJ)Lj$/time/temporal/u;

    move-result-object p1

    return-object p1

    .line 422
    :pswitch_2
    sget-object p1, Lj$/time/chrono/y;->d:Lj$/time/chrono/y;

    .line 226
    sget-object p1, Lj$/time/temporal/a;->DAY_OF_YEAR:Lj$/time/temporal/a;

    .line 669
    iget-object p1, p1, Lj$/time/temporal/a;->b:Lj$/time/temporal/u;

    .line 241
    iget-wide v3, p1, Lj$/time/temporal/u;->c:J

    .line 227
    sget-object p1, Lj$/time/chrono/y;->e:[Lj$/time/chrono/y;

    array-length v0, p1

    :goto_0
    if-ge v1, v0, :cond_2

    aget-object v5, p1, v1

    .line 228
    iget-object v6, v5, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 890
    invoke-virtual {v6}, Lj$/time/h;->Y()Z

    move-result v6

    if-eqz v6, :cond_0

    const/16 v6, 0x16e

    goto :goto_1

    :cond_0
    const/16 v6, 0x16d

    .line 228
    :goto_1
    iget-object v7, v5, Lj$/time/chrono/y;->b:Lj$/time/h;

    invoke-virtual {v7}, Lj$/time/h;->V()I

    move-result v7

    sub-int/2addr v6, v7

    add-int/2addr v6, v2

    int-to-long v6, v6

    invoke-static {v3, v4, v6, v7}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v3

    .line 229
    invoke-virtual {v5}, Lj$/time/chrono/y;->q()Lj$/time/chrono/y;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 230
    invoke-virtual {v5}, Lj$/time/chrono/y;->q()Lj$/time/chrono/y;

    move-result-object v5

    iget-object v5, v5, Lj$/time/chrono/y;->b:Lj$/time/h;

    invoke-virtual {v5}, Lj$/time/h;->V()I

    move-result v5

    sub-int/2addr v5, v2

    int-to-long v5, v5

    invoke-static {v3, v4, v5, v6}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v3

    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 422
    :cond_2
    sget-object p1, Lj$/time/temporal/a;->DAY_OF_YEAR:Lj$/time/temporal/a;

    .line 669
    iget-object p1, p1, Lj$/time/temporal/a;->b:Lj$/time/temporal/u;

    .line 253
    iget-wide v0, p1, Lj$/time/temporal/u;->d:J

    .line 147
    invoke-static {v3, v4, v0, v1}, Lj$/time/temporal/u;->g(JJ)Lj$/time/temporal/u;

    move-result-object p1

    return-object p1

    .line 199
    :pswitch_3
    sget-object p1, Lj$/time/chrono/y;->e:[Lj$/time/chrono/y;

    array-length v0, p1

    sub-int/2addr v0, v2

    aget-object v0, p1, v0

    .line 272
    iget-object v0, v0, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget v0, v0, Lj$/time/h;->a:I

    .line 199
    array-length v3, p1

    sub-int/2addr v3, v2

    aget-object v3, p1, v3

    .line 208
    iget-object v3, v3, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget v3, v3, Lj$/time/h;->a:I

    const v4, 0x3b9aca00

    sub-int/2addr v4, v3

    .line 209
    aget-object p1, p1, v1

    iget-object p1, p1, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget p1, p1, Lj$/time/h;->a:I

    move v1, v2

    .line 210
    :goto_2
    sget-object v3, Lj$/time/chrono/y;->e:[Lj$/time/chrono/y;

    array-length v5, v3

    if-ge v1, v5, :cond_3

    .line 211
    aget-object v3, v3, v1

    .line 212
    iget-object v5, v3, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget v5, v5, Lj$/time/h;->a:I

    sub-int/2addr v5, p1

    add-int/2addr v5, v2

    .line 213
    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v4

    .line 214
    iget-object p1, v3, Lj$/time/chrono/y;->b:Lj$/time/h;

    .line 762
    iget p1, p1, Lj$/time/h;->a:I

    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_3
    int-to-long v1, v4

    const p1, 0x3b9ac9ff

    sub-int/2addr p1, v0

    int-to-long v3, p1

    .line 147
    invoke-static {v1, v2, v3, v4}, Lj$/time/temporal/u;->g(JJ)Lj$/time/temporal/u;

    move-result-object p1

    return-object p1

    .line 405
    :pswitch_4
    new-instance v0, Lj$/time/temporal/t;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unsupported field: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 88
    invoke-direct {v0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 405
    throw v0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_4
        :pswitch_4
        :pswitch_4
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final z()Ljava/util/List;
    .locals 2

    .line 335
    sget-object v0, Lj$/time/chrono/y;->e:[Lj$/time/chrono/y;

    array-length v1, v0

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lj$/time/chrono/y;

    .line 387
    invoke-static {v0}, Lj$/time/b;->a([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
