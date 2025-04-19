# Running MySQL Server and Client on macOS with Podman

This guide walks you through setting up a MySQL server and client on a Mac using [Podman](https://podman.io/).

---

## 🚀 Steps to Bring Up MySQL Server and Client

1. **Install Podman**
   ```bash
   brew install podman
   ```

2. **Start the Podman machine**
   ```bash
   podman machine start
   ```

3. **Verify Podman is working**
   ```bash
   podman info
   ```

4. *(Optional)* Restart the Podman machine if needed
   ```bash
   podman machine start
   ```

5. **Run MySQL server in a container**
   ```bash
   podman run -d \
     --name mysql-container \
     -e MYSQL_ROOT_PASSWORD=root \
     -e MYSQL_DATABASE=e-commerce \
     -p 3306:3306 \
     mysql:8
   ```

6. **Update your PATH to include the MySQL client binaries**
   ```bash
   echo 'export PATH="/opt/homebrew/opt/mysql-client/bin:$PATH"' >> ~/.zshrc
   source ~/.zshrc
   ```

7. **Set environment flags for compiling MySQL-related tools**
   ```bash
   export LDFLAGS="-L/opt/homebrew/opt/mysql-client/lib"
   export CPPFLAGS="-I/opt/homebrew/opt/mysql-client/include"
   ```

8. **Connect to MySQL using the client**
   ```bash
   mysql -h 127.0.0.1 -P 3306 -u root -p
   ```

---

## ✅ Done!

You should now have both MySQL **server** and **client** running locally on your Mac. Happy coding!
