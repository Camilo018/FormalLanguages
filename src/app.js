import './styles.css';
import UI from './UI';
const ui = new UI();
import Services from './Services';
const services = new Services();
const snooze = ms => new Promise(resolve => setTimeout(resolve, ms));

document.getElementById('btn-sentence').addEventListener('click', async (event) => {
    event.preventDefault();
    const user = await document.getElementById('user').value;
    const city = await document.getElementById('city').value;
    const image = await document.getElementById('image').files;
    
    const formData = new FormData();
    formData.append("name", user);
    formData.append("city", city);
    formData.append('image',image[0]);

    const response = await fetch('http://localhost:4500/addCovid', {
        method: 'POST',
        body: formData
    });

    const data = await response.json();
    console.log(data);
});

document.getElementById('btn-pdf').addEventListener('click', async (event) => {
    event.preventDefault();
    const cityPDF = await document.getElementById('cityPDF').value; 
    const response = await fetch('http://localhost:3100/generatePDF/' + cityPDF);
    await snooze(150);
    const pdf = await response.arrayBuffer();
   
    const link = document.createElement( 'a' );
    link.style.display = 'none';
    document.body.appendChild( link );
    const blob = new Blob( [ pdf ], { type: 'application/pdf' } );	
    const objectURL = URL.createObjectURL( blob );
    link.href = objectURL;
    link.href = URL.createObjectURL( blob );
    link.download =  'Test.pdf';
    link.click();

});
