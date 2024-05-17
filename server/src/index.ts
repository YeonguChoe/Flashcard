import { createServer } from "http"
import * as fs from "fs/promises"

const userList = ["Java", "C++"]

createServer(async (req, res) => {
    try {
        if (req.method === "GET") {
            if (req.url === '/') {
                res.writeHead(200, { 'Content-Type': 'text/html;charset=utf-8' });
                const page = await fs.readFile("./homepage.html")
                return res.end(page)
            }
            if (req.url === '/page1') {
                res.writeHead(200, { 'Content-Type': 'text/html;charset=utf-8' });
                const page = await fs.readFile("./page1.html")
                res.end(page)
            }

            if (req.url === "/userList") {

                // console.log("Entering userList")
                let jsonList = JSON.stringify(userList)
                res.write(jsonList)
                res.end()
            }

            else {
                res.writeHead(404, { 'Content-Type': 'text/html;charset=utf-8' })
                return res.end("<h1>Cannot be reached</h1>")
            }
        }

        if (req.method === "POST") {
            if (req.url === "/newUser") {
                let body = "";
                req.on('data', (d) => {
                    body += d
                })
                req.on('end', () => {
                    let text = JSON.parse(body)
                    userList.push(text.x)
                })
            }
        }

        if (req.method === "DELETE") {
            if (req.url.startsWith("/user/")) {
                let item = req.url.split('/')
                let target = item[2]
                let indexOfTarget = userList.indexOf(target)
                userList.splice(indexOfTarget, 1)
            }
        }

        if (req.method === "PUT") {
            let text = ""

            req.on('data', (w) => {
                text += w
            })
            req.on('end', () => {

                let jsonFormat = JSON.parse(text)
                userList[1] = jsonFormat["value"]
            })
        }
    }

    catch (error) {
        res.writeHead(200, { 'Content-Type': 'text/plain;charset=utf-8' })
        res.end(error.message)
    }

}).listen(80, () => {
    console.log("8080번 포트에서 서버가 대기 중입니다")
})