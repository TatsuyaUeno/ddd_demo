# docker起動手順書

### 概要
postgresコンテナを使用しています
その起動手順を以下に記します


### 起動手順
- 作業ディレクトリに移動
```
cd ./doc/postgres
```
- コンテナ起動（バックグラウンドでプロセス起動）
```
docker compose up -d
```

### その他のコマンド
- コンテナの状態確認
```
docker ps -a
```
- コンテナ停止
```
docker compose stop
```
