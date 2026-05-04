.class public Lh8/n$m;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lh8/n;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "m"
.end annotation


# instance fields
.field public final a:Ljava/util/Map;

.field public final b:Lh8/n$j;

.field public c:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/Map;Lh8/n$j;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p2, p0, Lh8/n$m;->a:Ljava/util/Map;

    .line 4
    iput-object p3, p0, Lh8/n$m;->b:Lh8/n$j;

    const/4 p1, 0x0

    .line 5
    iput-boolean p1, p0, Lh8/n$m;->c:Z

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/String;Ljava/util/Map;Lh8/n$j;Lh8/n$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lh8/n$m;-><init>(Ljava/lang/String;Ljava/util/Map;Lh8/n$j;)V

    return-void
.end method

.method public static synthetic a(Lh8/n$m;)Z
    .locals 0

    .line 1
    invoke-virtual {p0}, Lh8/n$m;->f()Z

    .line 2
    .line 3
    .line 4
    move-result p0

    .line 5
    return p0
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
.end method

.method public static synthetic b(Lh8/n$m;)Ljava/util/Map;
    .locals 0

    .line 1
    invoke-virtual {p0}, Lh8/n$m;->e()Ljava/util/Map;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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
.end method

.method public static synthetic c(Lh8/n$m;)Lh8/n$j;
    .locals 0

    .line 1
    invoke-virtual {p0}, Lh8/n$m;->d()Lh8/n$j;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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
.end method


# virtual methods
.method public final d()Lh8/n$j;
    .locals 1

    .line 1
    iget-object v0, p0, Lh8/n$m;->b:Lh8/n$j;

    .line 2
    .line 3
    return-object v0
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
.end method

.method public final e()Ljava/util/Map;
    .locals 1

    .line 1
    iget-object v0, p0, Lh8/n$m;->a:Ljava/util/Map;

    .line 2
    .line 3
    return-object v0
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
.end method

.method public final f()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lh8/n$m;->c:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x0

    .line 6
    return v0

    .line 7
    :cond_0
    const/4 v0, 0x1

    .line 8
    iput-boolean v0, p0, Lh8/n$m;->c:Z

    .line 9
    .line 10
    return v0
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method
