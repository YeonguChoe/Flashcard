import express from "express";
const app = express();
const port = 3000;
app.get("/", (request, response) => {
    response.send("Hello World");
});
app.listen(port, () => {
    console.log(`Server ${port}`);
});
import { hey } from './helper.js';
console.log(hey);
//# sourceMappingURL=index.js.map