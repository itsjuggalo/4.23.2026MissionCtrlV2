.class public final Lrb/y0$i;
.super Lrb/y0$g;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrb/y0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "i"
.end annotation


# instance fields
.field public final f:Lrb/y0$j;


# direct methods
.method public constructor <init>(Ljava/lang/String;ZLrb/y0$j;)V
    .locals 2

    const/4 v0, 0x0

    .line 2
    invoke-direct {p0, p1, p2, p3, v0}, Lrb/y0$g;-><init>(Ljava/lang/String;ZLjava/lang/Object;Lrb/y0$a;)V

    .line 3
    const-string p2, "-bin"

    invoke-virtual {p1, p2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    const-string v1, "ASCII header is named %s.  Only binary headers may end with %s"

    .line 4
    invoke-static {v0, v1, p1, p2}, Lp6/n;->k(ZLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 5
    const-string p1, "marshaller"

    invoke-static {p3, p1}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lrb/y0$j;

    iput-object p1, p0, Lrb/y0$i;->f:Lrb/y0$j;

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/String;ZLrb/y0$j;Lrb/y0$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lrb/y0$i;-><init>(Ljava/lang/String;ZLrb/y0$j;)V

    return-void
.end method


# virtual methods
.method public h([B)Ljava/lang/Object;
    .locals 1

    .line 1
    iget-object v0, p0, Lrb/y0$i;->f:Lrb/y0$j;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lrb/y0$j;->b([B)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    return-object p1
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
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
    .line 25
    .line 26
.end method

.method public j(Ljava/lang/Object;)[B
    .locals 1

    .line 1
    iget-object v0, p0, Lrb/y0$i;->f:Lrb/y0$j;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lrb/y0$j;->a(Ljava/lang/Object;)[B

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    const-string v0, "null marshaller.toAsciiString()"

    .line 8
    .line 9
    invoke-static {p1, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    check-cast p1, [B

    .line 14
    .line 15
    return-object p1
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method
