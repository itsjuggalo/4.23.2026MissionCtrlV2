.class public final Lrb/b1$e$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrb/b1$e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public a:Ljava/util/List;

.field public b:Lrb/a;

.field public c:Lrb/b1$b;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    sget-object v0, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 5
    .line 6
    iput-object v0, p0, Lrb/b1$e$a;->a:Ljava/util/List;

    .line 7
    .line 8
    sget-object v0, Lrb/a;->c:Lrb/a;

    .line 9
    .line 10
    iput-object v0, p0, Lrb/b1$e$a;->b:Lrb/a;

    .line 11
    .line 12
    return-void
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method


# virtual methods
.method public a()Lrb/b1$e;
    .locals 4

    .line 1
    new-instance v0, Lrb/b1$e;

    .line 2
    .line 3
    iget-object v1, p0, Lrb/b1$e$a;->a:Ljava/util/List;

    .line 4
    .line 5
    iget-object v2, p0, Lrb/b1$e$a;->b:Lrb/a;

    .line 6
    .line 7
    iget-object v3, p0, Lrb/b1$e$a;->c:Lrb/b1$b;

    .line 8
    .line 9
    invoke-direct {v0, v1, v2, v3}, Lrb/b1$e;-><init>(Ljava/util/List;Lrb/a;Lrb/b1$b;)V

    .line 10
    .line 11
    .line 12
    return-object v0
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public b(Ljava/util/List;)Lrb/b1$e$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lrb/b1$e$a;->a:Ljava/util/List;

    .line 2
    .line 3
    return-object p0
    .line 4
    .line 5
    .line 6
    .line 7
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

.method public c(Lrb/a;)Lrb/b1$e$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lrb/b1$e$a;->b:Lrb/a;

    .line 2
    .line 3
    return-object p0
    .line 4
    .line 5
    .line 6
    .line 7
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

.method public d(Lrb/b1$b;)Lrb/b1$e$a;
    .locals 0

    .line 1
    iput-object p1, p0, Lrb/b1$e$a;->c:Lrb/b1$b;

    .line 2
    .line 3
    return-object p0
    .line 4
    .line 5
    .line 6
    .line 7
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
