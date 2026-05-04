.class public Lg9/u0;
.super Lg9/p;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final d:Ljava/util/List;


# direct methods
.method public constructor <init>(Lj9/q;Lbb/d0;)V
    .locals 1

    .line 1
    sget-object v0, Lg9/p$b;->k:Lg9/p$b;

    .line 2
    .line 3
    invoke-direct {p0, p1, v0, p2}, Lg9/p;-><init>(Lj9/q;Lg9/p$b;Lbb/d0;)V

    .line 4
    .line 5
    .line 6
    new-instance p1, Ljava/util/ArrayList;

    .line 7
    .line 8
    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    .line 9
    .line 10
    .line 11
    iput-object p1, p0, Lg9/u0;->d:Ljava/util/List;

    .line 12
    .line 13
    invoke-static {v0, p2}, Lg9/t0;->k(Lg9/p$b;Lbb/d0;)Ljava/util/List;

    .line 14
    .line 15
    .line 16
    move-result-object p2

    .line 17
    invoke-interface {p1, p2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 18
    .line 19
    .line 20
    return-void
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method


# virtual methods
.method public d(Lj9/h;)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lg9/u0;->d:Ljava/util/List;

    .line 2
    .line 3
    invoke-interface {p1}, Lj9/h;->getKey()Lj9/k;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    .line 8
    .line 9
    .line 10
    move-result p1

    .line 11
    xor-int/lit8 p1, p1, 0x1

    .line 12
    .line 13
    return p1
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method
