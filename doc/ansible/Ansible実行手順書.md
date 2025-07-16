# Ansible実行手順書

### 環境情報
OS:Ubuntu(20.04)

### Ansibleのインストール
- rootに切り替える
```
sudo su -
```
- パッケージ情報を更新
```
apt update
```
- Ansible をインストール
```
apt install -y ansible
```
- バージョン確認（インストール確認）
```
ansible --version
```
実行結果
```
ansible 2.10.8
  config file = None
  configured module search path = ['/root/.ansible/plugins/modules', '/usr/share/ansible/plugins/modules']
  ansible python module location = /usr/lib/python3/dist-packages/ansible
  executable location = /usr/bin/ansible
  python version = 3.10.12 (main, May 27 2025, 17:12:29) [GCC 11.4.0]
```

### Ansibleの実行
- 実行ディレクトリへ移動
```
cd ./doc/ansible
```
- Playbook 実行
```
ansible-playbook -i ddd_inventory.ini ddd_install.yml
```

※正常終了すること
