import requests
from bs4 import BeautifulSoup

servlet_url = "http://localhost:8080/lab1-homework-1.0-SNAPSHOT/generateTree?numVertices=5"

try:
    response = requests.get(servlet_url)

    if response.status_code == 200:
        soup = BeautifulSoup(response.text, "html.parser")
        table = soup.find("table")

        if table:
            for row in table.find_all("tr"):
                row_data = [cell.text for cell in row.find_all("td")]
                print(" ".join(row_data))
        else:
            print("Table not found in the HTML response.")
    else:
        print("HTTP GET request failed with response code: " + str(response.status_code))
except requests.exceptions.RequestException as e:
    print("An error occurred: " + str(e))
