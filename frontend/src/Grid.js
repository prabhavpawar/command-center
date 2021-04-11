import React, { useState } from 'react';
import { render } from 'react-dom';
import { AgGridColumn, AgGridReact } from 'ag-grid-react';
import {ClientSideRowModelModule} from "@ag-grid-community/client-side-row-model";
import {CsvExportModule} from "@ag-grid-community/csv-export";
import {ExcelExportModule} from "@ag-grid-enterprise/excel-export";
import {MasterDetailModule} from "@ag-grid-enterprise/master-detail";

import 'ag-grid-enterprise';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';

const Grid = () => {
    const [gridApi, setGridApi] = useState(null);
    const [gridColumnApi, setGridColumnApi] = useState(null);

    const [rowData, setRowData] = useState([
        {make: "Toyota", model: "Celica", price: 35000},
        {make: "Ford", model: "Mondeo", price: 32000},
        {make: "Porsche", model: "Boxter", price: 72000}
    ]);

    const [sidebar, setSidebar] = useState(
        {
            toolPanels: [
              {
                id: 'columns',
                labelDefault: 'Columns',
                labelKey: 'columns',
                iconKey: 'columns',
                toolPanel: 'agColumnsToolPanel',
              },
              {
                id: 'filters',
                labelDefault: 'Filters',
                labelKey: 'filters',
                iconKey: 'filter',
                toolPanel: 'agFiltersToolPanel',
              },
            ],
        }
    )

    function onGridReady(params) {
        setGridApi(params.api);
        setGridColumnApi(params.columnApi);
    }

    const onButtonClick = e => {
        const selectedNodes = gridApi.getSelectedNodes()
        const selectedData = selectedNodes.map( node => node.data )
        const selectedDataStringPresentation = selectedData.map( node => node.make + ' ' + node.model).join(', ')
        alert(`Selected nodes: ${selectedDataStringPresentation}`)
    }

    return (
        <div className="ag-theme-alpine" style={ { height: 400, width: 600 } }>
            <button onClick={onButtonClick}>Get selected rows</button>
            <AgGridReact
                rowData={rowData}
                rowSelection="multiple"
                // properties
                //columnDefs={columnDefs}
                sidebar={sidebar}
                modules={[ClientSideRowModelModule, CsvExportModule, ExcelExportModule, MasterDetailModule]}>
                <AgGridColumn field="make" sortable={true} filter={true} checkboxSelection={true} ></AgGridColumn>
                <AgGridColumn field="model" sortable={true} filter={true} ></AgGridColumn>
                <AgGridColumn field="price" sortable={true} filter={true} ></AgGridColumn>
            </AgGridReact>
        </div>
    );
};

export default Grid;