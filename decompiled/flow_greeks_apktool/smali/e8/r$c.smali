.class public Le8/r$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Le8/r;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "c"
.end annotation


# instance fields
.field public a:Z

.field public b:Lr8/n;


# direct methods
.method public constructor <init>(ZLr8/n;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-boolean p1, p0, Le8/r$c;->a:Z

    .line 4
    iput-object p2, p0, Le8/r$c;->b:Lr8/n;

    return-void
.end method

.method public synthetic constructor <init>(ZLr8/n;Le8/r$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Le8/r$c;-><init>(ZLr8/n;)V

    return-void
.end method


# virtual methods
.method public a()Lr8/n;
    .locals 1

    .line 1
    iget-object v0, p0, Le8/r$c;->b:Lr8/n;

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

.method public b()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Le8/r$c;->a:Z

    .line 2
    .line 3
    return v0
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
